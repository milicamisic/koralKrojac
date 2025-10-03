package com.ftn.sbnz.service.config;

import com.ftn.sbnz.model.models.CsvLoader;
import org.drools.decisiontable.ExternalSpreadsheetCompiler;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;

@Configuration
public class DroolsConfig {
    @Bean
    public KieContainer kieContainer() throws Exception {
        KieServices ks = KieServices.Factory.get();
        KieFileSystem kfs = ks.newKieFileSystem();

        // 1. Učitaj obična DRL pravila
        kfs.write(ResourceFactory.newClassPathResource("rules/forward/forward.drl"));

        // 2. Kompajliraj sve DRT + CSV parove
        compileSpreadsheet(kfs, "rules/forward/dress_base_length.drt", "rules/forward/dress_base_length.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_bust_correction.drt", "rules/forward/dress_bust_correction.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_hips_correction.drt", "rules/forward/dress_hips_correction.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_shoulders.drt", "rules/forward/dress_shoulders.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_sleeves.drt", "rules/forward/dress_sleeves.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_height.drt", "rules/forward/dress_height.xls");
        compileSpreadsheet(kfs, "rules/forward/dress_wrap.drt", "rules/forward/dress_wrap.xls");

        // 3. Build
        KieBuilder kieBuilder = ks.newKieBuilder(kfs).buildAll();
        if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException("Greška pri build-u pravila: " + kieBuilder.getResults());
        }

        return ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
    }



    private void compileSpreadsheet(KieFileSystem kfs, String drtPath, String csvPath) throws Exception {
        ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
        try (InputStream template = getClass().getClassLoader().getResourceAsStream(drtPath);
             InputStream data = getClass().getClassLoader().getResourceAsStream(csvPath)) {

            String drl = converter.compile(data, template, 2, 1); // ako CSV ima header u 1. redu
            String drlPath = "src/main/resources/" + csvPath.replace(".xls", ".drl");
            System.out.println(drlPath);
            // 👉 Debug ispis
            System.out.println("=== DRL generated from " + drtPath);
            System.out.println(drl);

            kfs.write(drlPath, drl);
        }
    }
//    @Bean
//    public KieContainer kieContainer() throws Exception {
//        KieServices ks = KieServices.Factory.get();
//        KieFileSystem kfs = ks.newKieFileSystem();
//
//        // 🔹 Učitaj obična DRL pravila (primer za t-shirt)
//        kfs.write(ResourceFactory.newClassPathResource("rules/forward/tshirt_rules.drl"));
//
//        // 🔹 Lista svih template + CSV fajlova koje želiš da kompajliraš
//        compileTemplate(kfs, "rules/forward/dress_base_length.drt", "rules/forward/dress_base_length.csv", "src/main/resources/rules/forward/dress_base_length.drl");
//        compileTemplate(kfs, "rules/forward/dress_wrap.drt",        "rules/forward/dress_wrap.csv",        "src/main/resources/rules/forward/dress_wrap.drl");
//        compileTemplate(kfs, "rules/forward/dress_bust.drt",        "rules/forward/dress_bust.csv",        "src/main/resources/rules/forward/dress_bust.drl");
//        compileTemplate(kfs, "rules/forward/dress_hips.drt",        "rules/forward/dress_hips.csv",        "src/main/resources/rules/forward/dress_hips.drl");
//        compileTemplate(kfs, "rules/forward/dress_sleeves.drt",     "rules/forward/dress_sleeves.csv",     "src/main/resources/rules/forward/dress_sleeves.drl");
//        compileTemplate(kfs, "rules/forward/dress_shoulders.drt",   "rules/forward/dress_shoulders.csv",   "src/main/resources/rules/forward/dress_shoulders.drl");
//        compileTemplate(kfs, "rules/forward/dress_height.drt",      "rules/forward/dress_height.csv",      "src/main/resources/rules/forward/dress_height.drl");
//
//        // 🔹 Build i container
//        KieBuilder kieBuilder = ks.newKieBuilder(kfs).buildAll();
//        if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
//            throw new RuntimeException("Greška pri build-u pravila: " + kieBuilder.getResults().toString());
//        }
//
//        return ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
//    }
//
//    private void compileTemplate(KieFileSystem kfs, String drtPath, String csvPath, String drlOutPath) throws Exception {
//        Resource template = ResourceFactory.newClassPathResource(drtPath);
//        Resource data = ResourceFactory.newClassPathResource(csvPath);
//
//        // 👇 Ovde koristiš loader koji zna da pročita CSV u pravu listu objekata
//        List<?> rows = CsvLoader.load(data, drtPath);
//
//        ObjectDataCompiler compiler = new ObjectDataCompiler();
//        String drl = compiler.compile(rows, template.getInputStream());
//
//        kfs.write(drlOutPath, drl);
//    }

}
