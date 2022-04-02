## Abbreviator ##

Annotate member variables for abbreviation

```java
public class User {
    @AbbreviateState
    private String state;
}
```

Instantiate

```java
Abbreviator abbreviator = new Abbreviator(object);
```

Abbreviate

```java
abbreviator.abbreviate();
```

## Address ##

Abbreviate address

```java
@Abbreviate(capitalize = false, usePeriod = true)
```

Required
- capitalize - Capitalize the abbreviation, e.g. Street to ST
- usePeriod - Add period to abbreviation, e.g. Street to ST. 

Optional
- aggressive - Default is false. 
  - false - Only words separated by non alphabetic characters will be abbreviated
  - true - All words, even substrings, will abbreviated. E.g. Streetstreet -> StSt

Data types supported
- String

## State ##

Abbreviate states

```java
@AbbreviateState
```

Optional
- aggressive - Default is false

Data types supported
- String
