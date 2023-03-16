# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer
HAMONO Hermine et ROY Raphaël

Les règles PMD fournies implémentent plusieurs tests smells différents.
Or, dans ceux vus en cours, il n'y a qu'un seul test implémentant plusieurs tests smells différents  : JUnitTestContainsTooManyAsserts.md

```java


public class MyTestCase extends TestCase {
    // Ok
    public void testMyCaseWithOneAssert() {
        boolean myVar = false;
        assertFalse("should be false", myVar);
    }

    // Bad, too many asserts (assuming max=1)
    public void testMyCaseWithMoreAsserts() {
        boolean myVar = false;
        assertFalse("myVar should be false", myVar);
        assertEquals("should equals false", false, myVar);
    }
}

        
```

Pour corriger ce test, il faudrait diviser les assert dans deux tests différents :
```java
    public void testMyCaseWithAssertFalse() {
        boolean myVar = false;
        assertFalse("myVar should be false", myVar);
        }
    public void testMyCaseWithMAssertEquals() {
        boolean myVar = false;
        assertEquals("should equals false", false, myVar);
        }    

```

On corrigerait ici le problème de test smells concernant le nombre d'asserts.
