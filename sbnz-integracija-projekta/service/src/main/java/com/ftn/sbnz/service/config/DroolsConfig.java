package com.ftn.sbnz.service.config;

import org.drools.decisiontable.ExternalSpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class DroolsConfig {

    // 🔹 Forward pravila – šabloni
//    @Bean
    public KieContainer forwardContainer() throws Exception {
        KieServices ks = KieServices.Factory.get();
        KieFileSystem kfs = ks.newKieFileSystem();

        // Obična forward pravila
        kfs.write(ResourceFactory.newClassPathResource("rules/forward/forward.drl"));

        // Šabloni za haljine
        compileSpreadsheet(kfs, "rules/forward/dress_base_length.drt", "rules/forward/dress_base_length.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_bust_correction.drt", "rules/forward/dress_bust_correction.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_hips_correction.drt", "rules/forward/dress_hips_correction.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_shoulders.drt", "rules/forward/dress_shoulders.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_sleeves.drt", "rules/forward/dress_sleeves.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_height.drt", "rules/forward/dress_height.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_wrap.drt", "rules/forward/dress_wrap.xls");

        // Build
        KieBuilder kieBuilder = ks.newKieBuilder(kfs).buildAll();
        if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException("Greška pri build-u forward pravila: " + kieBuilder.getResults());
        }

        return ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
    }

    // Bean za forward sesiju
    @Bean
    public KieSession forwardKsession() throws Exception {
        return forwardContainer().newKieSession();
    }

    // 🔹 CEP pravila – iz kmodule.xml
//    @Bean
    public KieContainer cepContainer() {
        KieServices ks = KieServices.Factory.get();
        return ks.getKieClasspathContainer(); // čita kmodule.xml
    }

    @Bean
    public KieSession cepKsession() {
        return cepContainer().newKieSession("cepKsession");
    }

    // Helper metoda za compile DRT+XLS
    private void compileSpreadsheet(KieFileSystem kfs, String drtPath, String xlsPath) throws Exception {
        ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
        try (InputStream template = getClass().getClassLoader().getResourceAsStream(drtPath);
             InputStream data = getClass().getClassLoader().getResourceAsStream(xlsPath)) {

            String drl = converter.compile(data, template, 2, 1); // ako CSV ima header u 1. redu
            String drlPath = "src/main/resources/" + xlsPath.replace(".xls", ".drl");

            System.out.println("=== DRL generated from " + drtPath);
            System.out.println(drl);

            kfs.write(drlPath, drl);
        }
    }
}