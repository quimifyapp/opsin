package com.quimify.organic.opsin;

import com.quimify.organic.opsin.english.NameToStructure;
import com.quimify.organic.opsin.english.OpsinResult;

public class OpsinEnglish {

    protected static final NameToStructure nameToStructure = NameToStructure.getInstance();

    private final boolean present;

    // If present = true:

    private final String smiles; // Simplified Molecular Input Line Entry Specification
    private final String cml; // Chemical Markup Language

    // Constructor:

    public OpsinEnglish(String name) {
        // Prefix "di" is problematic:
        name = correctEtherName(name);

        // Parsing:
        OpsinResult opsinResult = nameToStructure.parseChemicalName(name);

        present = opsinResult.getStatus() == OpsinResult.OPSIN_RESULT_STATUS.SUCCESS;
        smiles = opsinResult.getSmiles();
        cml = opsinResult.getCml();
    }

    // Private:

    private String correctEtherName(String name) {
        if(name.contains("ether")) {
            String correctedName = name.replaceFirst("di", "");

            // The "di" part may not refer the ether, but to a substituent:
            if(correctedName.trim().split("\\s+").length == 2) // As in "etil éter"
                name = correctedName;
        }

        return name;
    }

    // Getters:

    public boolean isPresent() {
        return present;
    }

    public String getSmiles() {
        return smiles;
    }

    public String getCml() {
        return cml;
    }

}
