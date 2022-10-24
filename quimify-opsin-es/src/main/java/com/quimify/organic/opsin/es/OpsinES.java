package com.quimify.organic.opsin.es;

public class OpsinES {

    protected static final NameToStructure nameToStructure = NameToStructure.getInstance();

    private final boolean present;
    private final String smiles; // Simplified Molecular Input Line Entry Specification
    private final String cml; // Chemical Markup Language

    // Constructor:

    public OpsinES(String name) {
        // Preprocessing:

        // Spanish syntax -> English syntax:
        if (name.contains(" de ")) { // "cloruro de sodio" (sodium chloride)
            String[] palabras = name.split(" de "); // {"cloruro", "sodio"}
            name = palabras[1] + " " + palabras[0]; // "sodio cloruro"
        }

        // Acids don´t have a prefix in English:
        name = name.replaceFirst("ácido|acido", ""); // No suffix is needed

        // Prefix "di" is problematic:
        name = correctEtherName(name);

        // Parsing:

        OpsinResult opsinResult = nameToStructure.parseChemicalName(name);

        // Result:

        present = opsinResult.getStatus() == OpsinResult.OPSIN_RESULT_STATUS.SUCCESS;
        smiles = opsinResult.getSmiles();
        cml = opsinResult.getCml();
    }

    // Private:

    private static String correctEtherName(String nombre) {
        if(nombre.contains("éter") || nombre.contains("eter")) {
            String correctedName = nombre.replaceFirst("di", "");

            // The "di" part may not refer the ether, but to a substituent:
            if(correctedName.trim().split("\\s+").length == 2) // As in "etil éter"
                nombre = correctedName;
        }

        return nombre;
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
