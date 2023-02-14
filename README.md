# Quimify Opsin

## Overview

Quimify Opsin is an adaptation and translation to Spanish of [OPSIN](https://github.com/dan2097/opsin) (Open Parser for Systematic IUPAC Nomenclature), a powerful parser for systematic IUPAC nomenclature. This project is intended to facilitate the generation of chemical structures from systematic IUPAC names in Spanish, and is used in [Quimify](https://quimify.com/).

## Usage Examples

### Paralell, from an English and a Spanish name:

```java
OpsinEN opsinEN = new OpsinES("2-methylpropanoic acid");

OpsinES opsinES = new OpsinES("ácido 2-metilpropanoico");
```

Check if name could be parsed:

```java
if (opsinEN.isPresent()) {
  // ...
}

if (opsinES.isPresent()) {
  // ...
}

```

Finally:

```java
opsinEN.getSmiles(); // CC(C(=O)O)C
opsinEN.getCML(); // Chemical Markup Language (too long)

opsinES.getSmiles(); // CC(C(=O)O)C
opsinES.getCML(); // Chemical Markup Language (too long)
```

## How it works
   
### Pre processing 

A pre-processing step is performed before parsing names with OPSIN. For instance:

From:

`diethyl ether`

To:

`ethyl ether`

### Translation 

Done by editing resource files. For instance:

From:

```XML
<token value="[Br-]">bromide|bromid</token>
<token value="[Cl-]">chloride|chlorid</token>
```

To:

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
