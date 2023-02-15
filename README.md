# Quimify Opsin

## Overview

This is an adaptation and a translation to Spanish of [OPSIN](https://github.com/dan2097/opsin) (Open Parser for Systematic IUPAC Nomenclature) used in [Quimify](https://quimify.com/).

## Usage Examples

### Paralell, from an English and a Spanish name:

Build it:

```java
String englishName = "2-methylpropanoic acid";
OpsinEN opsinEN = new OpsinES(englishName);
```

```java
String spanishName = "ácido 2-metilpropanoico";
OpsinES opsinES = new OpsinES(spanishName);
```

Result:

```java
if (opsinEN.isPresent()) {
    opsinEN.getSmiles(); // CC(C(=O)O)C
    opsinEN.getCml(); // Chemical Markup Language (too long)
}
```

```java
if (opsinES.isPresent()) {
    opsinES.getSmiles(); // CC(C(=O)O)C
    opsinES.getCml(); // Chemical Markup Language (too long)    
}
```

## How it works
   
### Pre processing 

Done before parsing names with OPSIN. For instance:

`diethyl ether` → `ethyl ether`

### Translation 

Done by editing resource files. For instance:

`.../en/resources/functionalTerms.xml`
```XML
<token value="[Br-]">bromide|bromid</token>
<token value="[Cl-]">chloride|chlorid</token>
```

`.../es/resources/functionalTerms.xml`
```XML
<token value="[Br-]">bromuro|brom</token><!--TRANSLATED-->
<token value="[Cl-]">cloruro|clor</token><!--TRANSLATED-->
```

## Usage
  
Clone the repository and run `Main` from module `quimify-opsin-en` or `quimify-opsin-es` using Java 11.

## Installation
  
To use Quimify Opsin in your project, you can generate a JAR file with dependencies by running the Maven task `package` with the command `mvn package`. The JAR files will be located at `quimify-opsin-en/target` and `quimify-opsin-es/target` respectively.

Alternatively, download the latest [release](https://github.com/quimifyapp/opsin/releases) available.

## Dependencies
  
Quimify OPSIN uses the `opsin-core` module from [OPSIN](https://github.com/dan2097/opsin).
