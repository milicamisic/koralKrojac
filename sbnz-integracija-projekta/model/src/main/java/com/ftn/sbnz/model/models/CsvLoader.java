package com.ftn.sbnz.model.models;

import org.kie.api.io.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {

    public static List<?> load(Resource csv, String templateName) {
        try {
            if (templateName.contains("dress_base_length")) {
                return loadDressBaseLength(csv);
            } else if (templateName.contains("dress_wrap")) {
                return loadDressWrap(csv);
            } else if (templateName.contains("dress_bust")) {
                return loadDressBust(csv);
            } else if (templateName.contains("dress_hips")) {
                return loadDressHips(csv);
            } else if (templateName.contains("dress_sleeves")) {
                return loadDressSleeves(csv);
            } else if (templateName.contains("dress_shoulders")) {
                return loadDressShoulders(csv);
            } else if (templateName.contains("dress_height")) {
                return loadDressHeight(csv);
            }
        } catch (Exception e) {
            throw new RuntimeException("Greška pri učitavanju CSV-a: " + csv, e);
        }
        throw new IllegalArgumentException("Nepoznat template: " + templateName);
    }

    private static List<DressBaseLengthRow> loadDressBaseLength(Resource csv) throws Exception {
        List<DressBaseLengthRow> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(csv.getInputStream()))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) { first = false; continue; } // preskoči header
                String[] parts = line.split(",");
                DressBaseLengthRow row = new DressBaseLengthRow();
                row.setDressType(parts[0].trim());
                row.setMinLength(Integer.parseInt(parts[1].trim()));
                row.setMaxLength(Integer.parseInt(parts[2].trim()));
                row.setBaseLength(Double.parseDouble(parts[3].trim()));
                rows.add(row);
            }
        }
        return rows;
    }

    private static List<DressWrapRow> loadDressWrap(Resource csv) throws Exception {
        List<DressWrapRow> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(csv.getInputStream()))) {
            String line; boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) { first = false; continue; }
                String[] parts = line.split(",");
                DressWrapRow row = new DressWrapRow();
                row.setType(parts[0].trim());
                row.setWrap(Boolean.parseBoolean(parts[1].trim()));
                row.setExtraLength(Double.parseDouble(parts[2].trim()));
                rows.add(row);
            }
        }
        return rows;
    }

    private static List<DressBustRow> loadDressBust(Resource csv) throws Exception {
        List<DressBustRow> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(csv.getInputStream()))) {
            String line; boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) { first = false; continue; }
                String[] parts = line.split(",");
                DressBustRow row = new DressBustRow();
                row.setMinBust(Integer.parseInt(parts[0].trim()));
                row.setMaxBust(Integer.parseInt(parts[1].trim()));
                row.setAdjustment(Double.parseDouble(parts[2].trim()));
                rows.add(row);
            }
        }
        return rows;
    }

    private static List<DressHipsRow> loadDressHips(Resource csv) throws Exception {
        List<DressHipsRow> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(csv.getInputStream()))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) { first = false; continue; } // preskoči header
                String[] parts = line.split(",");

                DressHipsRow row = new DressHipsRow();
                row.setType(parts[0].trim()); // Shift ili Bodycon
                row.setMinHips(Integer.parseInt(parts[1].trim()));
                row.setMaxHips(Integer.parseInt(parts[2].trim()));
                row.setAdjustment(Double.parseDouble(parts[3].trim()));

                rows.add(row);
            }
        }
        return rows;
    }

    private static List<DressSleevesRow> loadDressSleeves(Resource csv) throws Exception {
        List<DressSleevesRow> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(csv.getInputStream()))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) { first = false; continue; }
                String[] parts = line.split(",");

                DressSleevesRow row = new DressSleevesRow();
                row.setSleeveType(parts[0].trim()); // NONE, SHORT, LONG
                row.setMaxLength(Integer.parseInt(parts[1].trim())); // <20, ≥20, ili 0
                row.setAdjustment(Double.parseDouble(parts[2].trim()));

                rows.add(row);
            }
        }
        return rows;
    }

    private static List<DressShouldersRow> loadDressShoulders(Resource csv) throws Exception {
        List<DressShouldersRow> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(csv.getInputStream()))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) { first = false; continue; }
                String[] parts = line.split(",");

                DressShouldersRow row = new DressShouldersRow();
                row.setMinShoulder(Integer.parseInt(parts[0].trim()));
                row.setMaxShoulder(Integer.parseInt(parts[1].trim()));
                row.setAdjustment(Double.parseDouble(parts[2].trim()));

                rows.add(row);
            }
        }
        return rows;
    }

    private static List<DressHeightRow> loadDressHeight(Resource csv) throws Exception {
        List<DressHeightRow> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(csv.getInputStream()))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) { first = false; continue; }
                String[] parts = line.split(",");

                DressHeightRow row = new DressHeightRow();
                row.setMinHeight(Integer.parseInt(parts[0].trim()));
                row.setMaxHeight(Integer.parseInt(parts[1].trim()));
                row.setAdjustment(Double.parseDouble(parts[2].trim()));

                rows.add(row);
            }
        }
        return rows;
    }




}

