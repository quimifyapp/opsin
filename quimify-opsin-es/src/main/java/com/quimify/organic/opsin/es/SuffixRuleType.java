package com.quimify.organic.opsin.es;

enum SuffixRuleType {
	addgroup,
	addSuffixPrefixIfNonePresentAndCyclic,
	setOutAtom,
	changecharge,
	addFunctionalAtomsToHydroxyGroups,
	chargeHydroxyGroups,
	removeTerminalOxygen,
	convertHydroxyGroupsToOutAtoms,
	convertHydroxyGroupsToPositiveCharge,
	setAcidicElement
}
