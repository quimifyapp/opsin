package com.quimify.organic.opsin.spanish;

/**
 * A warning generated by OPSIN while interpreting a name.<br>
 * The specifics of the warning may be used to judge whether you want to accept the generated structure.
 */
public class OpsinWarning {
	
	/**
	 * The type of problem OPSIN encountered
	 */
	public enum OpsinWarningType {
		/**OPSIN ignored stereochemistry from the input name to give this structure. This can have various causes<br>:
		 * OPSIN doesn't support interpretation of the type of stereochemistry
		 * OPSIN stereo-perception doesn't support this type of stereocentre
		 * The name describes the wrong structure
		 * The stereochemistry is being requested at the wrong atom/bond */
		STEREOCHEMISTRY_IGNORED("Stereochemical term ignored"),
		/**OPSIN made a choice that appeared to be ambiguous to give this structure i.e. the name may describe multiple possible structures<br>
		 *The name may be missing locants<br>
		 *Alternatively the name could actually be a trivial rather than systematic name<br>
		 *OPSIN tries to make sensible choices when choosing in ambiguous cases so the resultant structure may nonetheless be the intended one*/
		APPEARS_AMBIGUOUS("This names appears to be ambiguous");
		
		private final String explanation;

		private OpsinWarningType(String explanation) {
			this.explanation = explanation;
		}
		
		public String getExplanation() {
			return explanation;
		}
		
	}
	
	private final OpsinWarningType type;
	private final String message;
	
	OpsinWarning(OpsinWarningType type, String message) {
		this.type = type;
		this.message = message;
	}

	/**
	 * @return The type of the warning c.f. {@link OpsinWarningType}
	 */
	public OpsinWarningType getType() {
		return type;
	}

	/**
	 * @return The message describing the specific cause of this warning
	 */
	public String getMessage() {
		return message;
	}
}
