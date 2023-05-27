# PAO-Project
Digital Classbok V2.0 ( Java Edition &lt;3 )

# Partea a II-a

## Repositories and Mappers
Am implementat Repositories and Mappers pentru clasele prezente in proiect. Sunt acoperite pentru majoritatea dintre ele operatiile CRUD precum si anumite adaugiri.

## Threads 
Am facut un Thread ce verifica din secunda in secunda mediile studentilor si le da update si mai da update la o variabila de tip Boolean ( Restanta ) din clasa Materie pentru fiecare student prezent in grupa.


## Logging and CSV Writing
Este implementat un sistem de Logging integrat cu cel de CSV Writing pentru a stoca toate actiunile facute de user in aplicatie.

## Design Patterns
Sunt prezente 2 Design Patterns in acest proiect. Primul este Singleton de tip Creational prezent in mai toate clasele de Repositories si in clasa de Meniu. 
Cel de-al doilea este Strategy de tip behavioral implementat la nivelul clasei Student unde hotarasc la runtime tipul de medie care se va calcula pentru un student( user-ul hotaraste asta )

## Exceptii
Sunt dezvoltate 3 tipuri de exceptii Custom:
- InvalidNameException
- OutOfRangeInputException
- UnknownStudentException

## Baza de Date
Baza de date este dezvoltata pe un BackEnd PostGreSQL deployed pe un Docker local. Ma conectez la ea folosind jdbc. 
Are in componenta sa 7 tabele.

## Clasa Sealed
Am transformat clasa Persoana intr-o clasa Sealed cu permitere pentru Student si Profesor.

## Iterator
Am implementat un iterator aflat in serviciul Grupei in metoda de afisare a studentilor impreuna cu notele lor.

------------------------------------------------------------------------------------------------------------------------------------------------


# Partea I

## Definirea sistemului
Aceasta aplicatie simuleaza un catalog online construit pe planul unui grupe studentesti cu un numar dat de studenti! ( sau pe baza unei clase dintr-o scoala)

Sistemul vine in ajutorul Secretariatului unei Facultati/Scoli care doreste sa faca o clasificare a studentilor 
pe baza mediei lor din timpul anului. 

## Precizari

- Notele, respectiv absentele trebuiesc adaugate una cate una
- Acelasi aspect se foloseste si la stergerea lor

# Meniul Aplicatiei

Meniul aplicatiei include 17 actiuni posibile, anume:

1) Afisati intreaga grupa
2) Afisati detaliile despre un anumit student

3) Adaugati note unui anumit student
4) Stergeti note unui anumit student

5) Adaugati absente unui anumit student
6) Stergeti absente unui anumit student

7) Afisati detalii despre restantele unui anumit student
8) Afisati numarul de restantieri ale grupei

9) Adaugati/Modificati un profesor
10) Stergeti un profesor

11) Afisati profesorii materiilor
                                
12) Afisati intreaga grupa in ordinea mediei
                
13) Adaugati un student nou
14) Stergeti un student
                
15) Modificati locatia grupei ( In urma unei relocari )

16) Cititi alta grupa
17) Iesiti din program


# Tipurile de obiecte prezente in proiect
- AllMaterii   ( Enum unde sunt prezente toate materiile definite in cadrul aplicatiei)
- FormaNota ( Clasa unde definesc forma unei note al unui student )
- Grupa ( Clasa centrala ce contine un TreeSet de Studenti, precum si informatii aferente grupei, cum ar fi locatia unde se tin cursurile pentru aceasta grupa )
- Locatie ( Clasa ce retine informatii despre locul de desfasurare a cursurilor unei grupe )
- Materie ( Clasa ce retine informatii despre notele unui Student, precum si absentele acestuia )
- Persoana ( Superclasa pentru sublcasele Student si Profesor )
- Profesor ( Subclasa ce retine inforamtii despre un profesor )
- Student ( Subclasa ce retine informatii despre un student )

# Interfete

Am implementat in cadrul proiectului 4 interfete ce sustin baza pentru cele 4 clase Serviciu.
Cele 4 interfete sunt:
- GrupaInterfata
- MateriiInterfata
- ProfesoriInterfata
- StudentInterfata

#### Toate 4 includ prototipurile functiilor aferente claselor Serviciu, care sunt si ele la randul lor implementari ale acestor interfete.

# Clasele Serviciu

Cum am scris anterior, clasele Serviciu prezente in aplicatie, anume:
- ServiciiGrupa
- ServiciiMaterii
- ServiciiProfesori
- ServiciiStudent
##### sunt implementari ale interfetelor aferente lor. Ele includ actiuni precum:

- Adaugare, stergere de studenti
- Setare automata de medie, respectiv de restanta pentru un student in cadrul tuturor materiilor
- Adaugare, stergere de Nota
- Returnarea unui student pe baza numelui sau pe baza CNP-ului
- Adaugarea, stergerea unui profesor
- Statistica grupei
- Verificarea de existenta a unui student dat ( pe baza numelui )
- etc

# Observatii cu privire la proiect ( cum s-a implementat ) 
#### Am folosit structuri precum ArrayList, TreeSet si Vector pentru a retine toate informatiile necesare precum:
- Retinerea intr-o structura a studentilor
- Retinerea notelor, respectiv absentelor aferente unui student din cadrul unei materii
#### Clasa Persoana este o casa abstracta si totodata si superclasa pentru subclasele Student si Profesor.
#### Sortarea studentilor este facuta cu ajutorul unui comparator definit in clasa Student unde compar studentii pe baza mediei


