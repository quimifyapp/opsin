package com.quimify.organic.opsin;

import com.quimify.organic.opsin.es.NameToStructure;
import com.quimify.organic.opsin.es.OpsinResult;

public class OpsinES {

    protected static final NameToStructure nameToStructure = NameToStructure.getInstance();

    private final boolean present;

    // If present = true:

    private final String smiles; // Simplified Molecular Input Line Entry Specification
    private final String cml; // Chemical Markup Language

    // Constructor:

    public OpsinES(String name) {
        // Words ordering:
        name = correctSpanishSyntax(name);

        // Acids don´t have a prefix in English but rather a suffix, which OPSIN doesn't need:
        name = name.replaceFirst("ácido|acido", "");

        // Prefix "di" is problematic:
        name = correctEtherName(name);

        // Parsing:
        OpsinResult opsinResult = nameToStructure.parseChemicalName(name);

        present = opsinResult.getStatus() == OpsinResult.OPSIN_RESULT_STATUS.SUCCESS;
        smiles = opsinResult.getSmiles();
        cml = opsinResult.getCml();
    }

    // Private:

    private String correctSpanishSyntax(String name) {
        if (name.contains(" de ")) { // "cloruro de sodio" (sodium chloride)
            String[] words = name.split(" de "); // {"cloruro", "sodio"}
            name = words[1] + " " + words[0]; // "sodio cloruro"
        }

        return name;
    }

    private String correctEtherName(String name) {
        if(name.contains("éter") || name.contains("eter")) {
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
