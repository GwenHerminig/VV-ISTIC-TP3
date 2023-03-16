# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer
 HAMONO Hermine et ROY Raphaël
1.   L'assertion rend faux car on a une multiplication entre un double et un int. Cette multiplication peut poser des problèmes d'arrondis, donc rendra faux à l'assertion. pour rendre le bon résultat il faut bien s'assurer d'avoir des types correspondants dans le cadre de calculs pour ne pas créer d'autres erreurs

2.   La différence entre `assertEquals` et `assertSame` est que assertEquals permet de comparer deux objets de même type pour voir si ils sont égaux, alors que assertSame permet de voir si les deux objets sont les mêmes, qu'ils occupent donc la même place de mémoire sur l'ordinateur. Si nous avons deux objets :
```java
   public class TestAssertions {
    @Test
    public void testString() {
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = s1;
        
        // assertEquals vérifie si les valeurs des chaînes de caractères sont égales
        assertEquals(s1, s2); // renvoie true
        assertEquals(s1, s3); // renvoie true
        
        // assertSame vérifie si les objets sont identiques (même référence)
        assertSame(s1, s2); // renvoie false
        assertSame(s1, s3); // renvoie true
    } 
}

```
-   Nous constatons ici que s1 et s3 sont à la fois égaux et identiques car s3 a été créé à partir de s1, et s1 et s2 sont égaux mais non identiques.

3. Plusieurs autres utilisations sont possibles pour la méthode 'fail' :

    - Pour tester des hypothèses : la méthode fail peut être utilisée pour tester des hypothèses dans le cadre de tests unitaires. Par exemple, si vous avez une hypothèse sur les données d'entrée qui doivent être vérifiées avant l'exécution d'un test, vous pouvez appeler fail pour signaler que l'hypothèse n'est pas vérifiée.
      Par exemple, ici :

```java
    @Test
public void testDiviserParZero() {
    try {
        divisor(10, 0);
        fail("Exception ArithmeticException attendue !");
    }   catch (ArithmeticException e) {
        // L'exception a bien été levée, le test réussit.
        }
    }
```
- Ici, la division par zéro étant impossible, l'exception rendue est écrite au niveau du fail pour écrire l'exception attendue.
  On peut également utiliser le fail pour marquer du code non implémenté, ce qui simule le fonctionnement d'un TODO.

4.  L'utilisation de assertThrows rend les tests plus clairs, plus précis et plus sûrs, ce qui facilite la détection et la résolution des erreurs dans le code testé.
