package fr.sdv.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompositeTest {

    private Service dsin;
    private Service bigData;
    private Service javaDev;

    @BeforeEach
    void setUp() {
        bigData = new Service("Big Data");
        bigData.ajouter(new Employe("RANMEY",  "JB",    7500));
        bigData.ajouter(new Employe("DOE",     "Jane",  3500));

        javaDev = new Service("Java Dev");
        javaDev.ajouter(new Employe("GUINEAU", "Kevin", 7500));
        javaDev.ajouter(new Employe("MARTIN",  "Paul",  3500));

        dsin = new Service("DSIN");
        dsin.ajouter(new Employe("RASPEY",  "Cécile", 10000));
        dsin.ajouter(new Employe("BECHKAR", "Bilel",   8000));
        dsin.ajouter(bigData);
        dsin.ajouter(javaDev);
    }

    @Test
    void testSalairEmploye() {
        Employe emp = new Employe("DOE", "John", 5000);
        assertEquals(5000, emp.calculerSalaire());
    }

    @Test
    void testSalaireBigData() {
        assertEquals(11000, bigData.calculerSalaire());
    }

    @Test
    void testSalaireJavaDev() {
        assertEquals(11000, javaDev.calculerSalaire());
    }

    @Test
    void testSalaireDSIN() {
        // 10000 + 8000 + 11000 + 11000 = 40000
        assertEquals(40000, dsin.calculerSalaire());
    }

    @Test
    void testAjoutSousService() {
        Service newService = new Service("Design");
        newService.ajouter(new Employe("DUPONT", "Alice", 4000));
        dsin.ajouter(newService);
        assertEquals(44000, dsin.calculerSalaire());
    }
}
