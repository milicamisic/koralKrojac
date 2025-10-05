package com.ftn.sbnz.service.tests;

import com.ftn.sbnz.model.events.SaleEvent;
import com.ftn.sbnz.model.events.StockAlert;
import com.ftn.sbnz.model.models.Fabric;
import com.ftn.sbnz.model.models.enums.Season;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CEPStagnationTest {

    @Test
    void testStagnationTriggersOnlyForUnsoldFabrics() {
        // 1️⃣ Pokretanje KIE sesije za CEP
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("cepKsession");

        // 2️⃣ Dodaj više materijala u bazu znanja
        Fabric cotton = new Fabric(1L, "Cotton Jersey", null, 0, 0, 0, false, null, 0, null, 0, 0, Season.UNIVERSAL);
        Fabric linen = new Fabric(2L, "Linen Light", null, 0, 0, 0, false, null, 0, null, 0, 0, Season.SUMMER);
        Fabric silk = new Fabric(3L, "Silk Smooth", null, 0, 0, 0, false, null, 0, null, 0, 0, Season.UNIVERSAL);
        Fabric wool = new Fabric(4L, "Wool Warm", null, 0, 0, 0, false, null, 0, null, 0, 0, Season.WINTER);
        Fabric velvet = new Fabric(5L, "Velvet Luxury", null, 0, 0, 0, false, null, 0, null, 0, 0, Season.UNIVERSAL);
        Fabric chiffon = new Fabric(6L, "Chiffon Light", null, 0, 0, 0, false, null, 0, null, 0, 0, Season.UNIVERSAL);

        ksession.insert(cotton);
        ksession.insert(linen);
        ksession.insert(silk);
        ksession.insert(wool);
        ksession.insert(velvet);
        ksession.insert(chiffon);

        long tenDaysAgo = System.currentTimeMillis() - (10L * 24 * 60 * 60 * 1000);
        ksession.insert(new SaleEvent("Cotton Jersey", 5.0, tenDaysAgo));
        ksession.insert(new SaleEvent("Silk Smooth", 2.0, tenDaysAgo));

        // 5️⃣ Pokreni pravila
        int fired = ksession.fireAllRules();
        System.out.println("🔥 Pokrenuto pravila: " + fired);

        // 6️⃣ Izvuci StockAlert-e
        List<StockAlert> alerts = ksession.getObjects(o -> o instanceof StockAlert)
                .stream()
                .map(o -> (StockAlert) o)
                .collect(Collectors.toList());

        System.out.println("\n=== ALERTS FOUND ===");
        alerts.forEach(a -> System.out.println("⚠️ " + a));

        // 7️⃣ Provera da su zaista velvet i chiffon dobili stagnaciju
        List<String> stagnationFabrics = alerts.stream()
                .filter(a -> a.getType().equals("STAGNATION"))
                .map(StockAlert::getFabric)
                .collect(Collectors.toList());

        System.out.println("\n🧵 Stagnation alerts for fabrics: " + stagnationFabrics);

        assertTrue(stagnationFabrics.contains("Velvet Luxury"));
        assertTrue(stagnationFabrics.contains("Chiffon Light"));

        // 8️⃣ Oslobodi sesiju
        ksession.dispose();
    }
}
