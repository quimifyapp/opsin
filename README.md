# Quimify Opsin

## Overview

Quimify Opsin is an adaptation and translation to Spanish of [OPSIN](https://github.com/dan2097/opsin) (Open Parser for Systematic IUPAC Nomenclature), a powerful parser for systematic IUPAC nomenclature. This project is intended to facilitate the generation of chemical structures from systematic IUPAC names in Spanish, and is used in [Quimify](https://quimify.com/) as a library of [quimifyapp/organic](https://github.com/quimifyapp/organic).

## Usage Examples

### Paralell, from an English and a Spanish name:

Build it:

```java
String englishName = "2-methylpropanoic acid";
OpsinEnglish opsinEnglish = new OpsinEnglish(englishName);
```

```java
String spanishName = "ácido 2-metilpropanoico";
OpsinSpanish opsinSpanish = new OpsinSpanish(spanishName);
```

Result:

```java
if (opsinEnglish.isPresent()) {
    opsinEnglish.getSmiles(); // CC(C(=O)O)C
    opsinEnglish.getCml(); // Chemical Markup Language (too long)
}
```

```java
if (opsinSpanish.isPresent()) {
    opsinSpanish.getSmiles(); // CC(C(=O)O)C
    opsinSpanish.getCml(); // Chemical Markup Language (too long)    
}
```

## How it works

### Pre processing

Done before parsing names with OPSIN. For instance:

`diethyl ether` → `ethyl ether`

### Translation

Done by editing resource files. For instance:

`.../english/resources/functionalTerms.xml`
```XML
<token value="[Br-]">bromide|bromid</token>
<token value="[Cl-]">chloride|chlorid</token>
```

`.../spanish/resources/functionalTerms.xml`
```XML
<token value="[Br-]">bromuro|brom</token><!--TRANSLATED-->
<token value="[Cl-]">cloruro|clor</token><!--TRANSLATED-->
```

## Usage

Clone the repository and run `Main` from module `quimify-opsin-english` or `quimify-opsin-spanish` using Java 11.

## Installation

To use Quimify Opsin in your project, you can generate a JAR file with dependencies by running the Maven task `package` with the command `mvn package`. The JAR files will be located at `quimify-opsin-english/target` and `quimify-opsin-spanish/target` respectively.

Alternatively, download the latest [release](https://github.com/quimifyapp/opsin/releases) available.

## Dependencies

Quimify OPSIN uses the `opsin-core` module from [OPSIN](https://github.com/dan2097/opsin).

## License

Do whatever you want with this code.

However, please be aware that our code relies on open-source dependencies, each with their own licenses and usage terms. Non-compliance with their licenses could have legal consequences.
