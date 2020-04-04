**ΠΟΛΥΤΕΧΝΕΙΟ ΚΡΗΤΗΣ**

**ΣΧΟΛΗ Η.Μ.Μ.Υ**

**ΤΕΧΝΗΤΗ ΝΟΗΜΟΣΥΝΗ - ΠΛΗ417**



### Επίλυση Θεωρητικών Ασκήσεων 

### Σετ 1

**Παντελής Κωνσταντίνος**

**2015030070**



#### Άσκηση 1

Δοθέντος ενός δένδρου αναζήτησης ζητείται ή επίδειξη εκτέλεσης διαφόρων τεχνικών αναζήτησης, να σημειωθεί ότι εκκινούμε από την S - Start (ρίζα) με στόχο το G - Goal.



<img src="C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200331064257487.png" alt="image-20200331064257487" style="zoom: 80%;" />

##### Α) Breadth-First Search (BFS)

Εκκινούμε από τον S διασχίζοντας κάθε νοητό επίπεδο του δέντρου, αν βρούμε τον κόμβο στόχο σταματούμε διαφορετικά προσπελαύνουμε του κόμβους του επόμενου νοητού επιπέδου.

Παραλλαγή του αλγορίθμου Best First Search με 
$$
f(n) = depth(n)
$$
Ακολουθεί η αρίθμηση των κόμβων με σειρά προσπέλασης.

<img src="C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200331064759744.png" alt="image-20200331064759744" style="zoom:80%;" />



**Μειονέκτημα:**

Απαιτεί χώρο - μεγάλη χωρική πολυπλοκότητα ( $ O(d)  $ συγκεκριμένα με $ d: βάθος\space δένδρου $). 

**Πλεονέκτημα:**

Σχετικά γρήγορη σε σύγκριση με την BFS.

##### Β) Depth-First Search (DFS)

Εκκινούμε από τον S διασχίζοντας κάθε νοητή στήλη του δέντρου από τα αριστερά προς τα δεξιά. Αν ο στόχος ευρεθεί σταματούμε, διαφορετικά συνεχίζουμε με την δεξιότερη στήλη.

Παραλλαγή του αλγορίθμου Best First Search με:

​		
$$
f(n)= 
	\left\{
	\begin{array}{ll}
		-depth(n)   \\
		-1 \over depth(n) 
	\end{array}
\right.
$$


Ακολουθεί η αρίθμηση των κόμβων με σειρά επίσκεψης.

<img src="C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200331065134355.png" alt="image-20200331065134355" style="zoom:80%;" />

**Μειονέκτημα:**

Αν υπάρχει κόμβος κοντά στη ρίζα (S) αλλά όχι στα πρώτα υποδένδρα τότε αυτός θα ευρεθεί σχετικά "αργά".

**Πλεονέκτημα:**

Μικρή χωρική πολυπλοκότητα (μικρότερη της DFS) Ο(n) (n: αριθμός κόμβων).

##### Γ) Itterative Deeping Search (IDS - IDDFS)

Αναζητούμε επαναληπτικά εκκινώντας από την αρχή επεκτείνοντας το βάθος σε κάθε επανάληψη.

<img src="C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200331070614988.png" alt="image-20200331070614988" style="zoom:80%;" />

| Επανάληψη      | 1    | 2          | 3                   | 4                                      |
| -------------- | ---- | ---------- | ------------------- | -------------------------------------- |
| **Προσβάσεις** | Α    | A, B ,C, D | A,B,E,F,C,G,H,D,I,J | A,B,E,K,F,L,M,C,G,H,N,D,I,O **(Goal)** |

Ακολουθούν οι κόμβοι σημειωμένοι με σειρά προσπέλασης



<img src="C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200331072650748.png" alt="image-20200331072650748" style="zoom:80%;" />

Πρακτικά αποτελεί μια τακτική η οποία συνδυάζει την χωρητική αποτελεσματικότητα (space efficiency) της DFS  και την ταχύτητα της BFS (για κόμβους κοντά στην ρίζα).





Αλγόριθμος σε ψευδογλώσσα:

```java
// Returns true if target is reachable from
// src within max_depth levels.
boolean IDDFS(src, target, max_depth)
    for limit from 0 to max_depth
       if DLS(src, target, limit) == true
           return true
    return false   

boolean DLS(src, target, limit)

    // done - base case       
    if (src == target)
        return true;

    // If reached the maximum depth, 
    // stop recursing.
    if (limit <= 0)
        return false;  

	// recursion, memory should be taken into consideration on large 		// apps.
    foreach adjacent i of src
        if DLS(i, target, limit?1)             
            return true

    return false
```

##### Δ) Uniform Cost  Search (UCS)

Παραλλαγή BFS με επέκταση κόμβου με μικρότερο κόστος διαδρομής, αλλά και του Α* αλγορίθμου.

Δηλαδή η UCS είναι:



- Breadth (αλλά και Best First Search)  First Search με $f(n) = g(n)$

  ​		
  
- A* με $h(n) = 0$
  
  

Ακολουθούν οι κόμβοι με σειρά προσπέλασης:

<img src="C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200402130841868.png" alt="image-20200402130841868" style="zoom:80%;" />



#### Άσκηση 2 (*Άσκηση 2.2 από βιβλίο*)

Εν γένει παρότι τόσο η απόδοση όσο και οι utility functions μετρούν - ποσοτικοποιούν την επίδοση ενός πράκτορα, οι δύο τους παρουσιάζουν σημαντικές διαφορές οι οποίες αναλύονται ακολούθως.

##### Απόδοση

Κριτήριο που χρησιμοποιείται από εξωτερικό παρατηρητή στην αξιολόγηση επιτυχίας πράκτορα.

##### Utility Function

Χρησιμοποιείται από τον πράκτορα, για να αξιολογήσει το κατά πόσο μια κατάσταση/κίνηση (μελλοντική ή παρελθοντική) είναι επιθυμητή. 



Συνεπώς η βασική διαφορά των δύο εννοιών ανάγεται στην οντότητα η οποία τις εφαρμόζει (δίπολο αξιολογητή/παρατηρητή - πράκτορα).

Επιπλέον μια utility function μπορεί να μην έχει καν ορισθεί για τον υπό εξέταση πράκτορα ενώ η απόδοση αποτελεί έννοια η οποία πάντοτε θα μπορεί να ορισθεί (δεδομένου κριτηρίου).

**Συμπερασματικά:**

| Attributes per Measure                | Performance                                  | Utility Function                                             |
| ------------------------------------- | -------------------------------------------- | ------------------------------------------------------------ |
| User                                  | Outside Observer                             | Agent itsself                                                |
| Always Present - Applicable - Defined | Yes                                          | No                                                           |
| Usage                                 | Evaluation of success from outside observers | Evaluation of desirabillity concerning states or histories from an Agent |

 #### Άσκηση 3 (*Άσκηση 3.9 από βιβλίο*)



#### Άσκηση 4 (*Άσκηση 3.12 από βιβλίο*)

##### Πρώτο Σκέλος

***"Prove that uniform-cost search and breadth-first search with constant step costs are optimal when used with the GRAPH-SEARCH algorithm"***

Γενικά τόσο η Unified Cost Search (UCS) όσο και η Breadth First Search (BFS)  αποτελούν ταυτοτικές διαδικασίες όταν όλα βηματικά κόστη (step - costs) είναι ίσα, οπότε η απόδειξη μπορεί να λάβει χώρα για μία εκ των δύο μεθόδων.

Το παραπάνω πρακτικά συμβαίνει λόγω του ότι και οι δύο μέθοδοι επεκτείνουν κόμβους με κριτήριο το g(n) - path cost για σταθερά βηματικά κόστη (step costs).

***Α' τρόπος:***

Σύμφωνα λοιπόν με τα παραπάνω είναι δόκιμο να λεχθεί ότι αν ο τρέχων κόμβος έχει αναπτυχθεί στο παρελθόν, το τρέχον μονοπάτι για αυτόν θα είναι πιο κοστοβόρο οπότε μπορούμε να το απορρίψουμε. 

***Β' τρόπος:***

Εναλλακτικά όταν ένας κόμβος, που δεν έχει υποστεί επίσκεψη στο παρελθόν (unvisited), υφίσταται επίσκεψη το κόστος θα είναι το ελάχιστο. 

Επιπλέον εφόσον λαμβάνει χώρα GRAPH_SEARCH κάθε κόμβος υφίσταται μοναδική επίσκεψη. Οπότε αν ο κόμβος στόχος επισκεφθεί τότε έχουμε την βέλτιστη λύση.



##### Δεύτερο Σκέλος

***" Show a state space with varying step costs in which GRAPH-SEARCH using iterative deepening finds a suboptimal solution"***



<img src="C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200401183631466.png" alt="image-20200401183631466" style="zoom:67%;" />



Γενικά για κάθε δέντρο για το οποίο ισχύει:
$$
G(n) \geqslant g(n)
$$

Αποτελεί παράδειγμα



<img src="C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200401183603770.png" alt="image-20200401183603770" style="zoom:67%;" />



#### Άσκηση 5 (*Άσκηση 3.15 από βιβλίο*)

**α.**	

Αναφορικά με τις διαθέσιμες καταστάσεις και τα μονοπάτια, αυτά είναι άπειρα αν κανείς λάβει υπόψη του όλα τα διαθέσιμα $(x,y)$ ζεύγη.

**β.** 

Δεδομένου ότι είναι δυνατό (δεν υπάρχουν εμπόδια ή άλλοι περιορισμοί ) η κοντινότερη απόσταση μεταξύ δύο κορυφών είναι μία ευθεία γραμμή.

Αν αυτό δεν είναι δυνατό εξαιτίας εμποδίων τότε η επόμενη κοντινότερη απόσταση είναι μια ακολουθία ημιευθειών (γραμμών) η οποία θα αποκλίνει από την ευθεία γραμμή όσο το δυνατόν λιγότερο.

Συγκεκριμένα το πρώτο τμήμα της αυτής ακολουθίας γραμμών θα πρέπει να ξεκινάει από το αρχικό σημείο σε κάποιο εφαπτόμενο στο εμπόδιο σημείο (τ. ώστε να εφάπτεται ακριβώς στο εμπόδιο ώστε να ελαχιστοποιηθεί το μονοπάτι - απόκλιση). 

Προφανώς δεδομένου ότι τα εμπόδια είναι πολύγωνα (βλ. Εικόνα παρακάτω) τα εφαπτόμενα σημεία θα πρέπει να είναι ακμές αυτών, οπότε το μονοπάτι πλέον διαμορφώνεται από ακμή σε ακμή. 

Πλέον λοιπόν ο νέος χώρος καταστάσεων διαμορφώνεται σε ένα σετ ακμών (35 συνολικά στην Εικόνα)

*Εικόνα - Ο χώρος κίνησης*

<img src="C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200401201056253.png" alt="image-20200401201056253" style="zoom:80%;" />



#### Άσκηση 6 (*Άσκηση 3.17 από βιβλίο*)

 **α.** 

***"Suppose that actions can have arbitrarily large negative costs; explain why this possibility would force any optimal algorithm to explore the entire state space."***

Σε αυτό το σενάριο κάθε δεδομένο μονοπάτι μπορεί να οδηγήσει σε αυθαίρετα μεγάλη απολαβή (arbitraily large reward), οπότε για την εύρεση του βέλτιστου θα έπρεπε ιδανικά να επεκταθούν όλα τα πιθανά μονοπάτια.

 **β.** 

***"Does it help if we insist that step costs must be greater than or equal to some negative constant c? Consider both trees and graphs."***

Υποθέτοντας ότι η μέγιστη απολαβή είναι μία σταθερά c έχουμε:

- Αν γνωρίζουμε το μέγιστο βάθος (maximum depth) του δέντρου που απεικονίζει το χώρο καταστάσεων (state space), μπορούμε να βελτιώσουμε κάθε μονοπάτι k-επιπέδων κατά $cd $, κλαδεύοντας τα υπό - μονοπάτια τα οποία είναι "χειρότερα" από $cd$ .

- To παραπάνω δεν αναμένεται να αποδώσει σε χώρους καταστάσεων (state spaces) με επαναλήψεις (loops) και γράφους , λόγω της φύσης της επαναληπτικότητας καθαυτής ( ***reward/itteration = c*** ).

  

 **γ.** 

***"Suppose that there is a set of operators that form a loop, so that executing the set in some order results in no net change to the state. If all of these operators have negative cost, what does this imply about the optimal behavior for an agent in such an environment?"***

Ένας βέλτιστος πράκτορας θα πρέπει να σχεδιάσει να ακολουθεί το επαναληπτικό μοτίβο επ' άπειρο καθότι μειώνεται η τιμή του κόστους, εκτός κι αν μπορεί να βρει άλλο μοτίβο με καλύτερη ανταμοιβή.



 **δ.** 

***"One can easily imagine operators with high negative cost, even in domains such as route finding. For example, some stretches of road might have such beautiful scenery as to far outweigh the normal costs in terms of time and fuel. Explain, in precise terms, within the context (of state-space search, why humans do not drive round scenic loops indefinitely, and explain how to define the state space and operators for route ,finding so that artificial agents can also avoid looping"***

Καταρχάς λόγω πόρων και της περιορισμένης φύσης αυτών το παραπάνω είναι αδύνατο σε πραγματικές συνθήκες. 

Το κυριότερο όμως γεγονός αφορά τη μνήμη που τα ανθρώπινα όντα φέρουν, δηλαδή ένα όμορφο τοπίο και η αξία του εκτιμάται τις πρώτες φορές που κάποιος το επισκέπτεται, τις επόμενες το τοπίο και κάθε επαναληπτική κατάσταση ανάγεται εν τέλει σε φορτική επιβάρυνση παρά σε αξιόλογη δραστηριότητα.

Για να μοντελοποιηθεί το παραπάνω σε τεχνητά όντα - πράκτορες είναι αναγκαίο να εισαχθεί η έννοια της μνήμης σε αυτούς. 

Το παραπάνω μπορεί να γίνει επεκτείνοντας τον χώρο καταστάσεων ( state space ) ώστε να περιλαμβάνει μια μορφή μνήμης, απεικονίζοντας πλέον την κάθε κατάσταση ώς σετ τρέχουσας τοποθεσίας αλλά και τοποθεσιών που έχουν ήδη επισκεφθεί.

Ενδεικτικά:

```java
			<Location currLoc, boolean isVisited>
```



**ε.** 

***" Can you think of a real domain in which step costs are such as to cause looping?"***

Τα παραδείγματα στον πραγματικό κόσμο είναι αρκετά, αναφέρονται μερικά ενδεικτικά:

- Πείνα - Κατανάλωση σοκολάτας ή σελίνου (αυξάνουν την αίσθημα πείνας) - Πείνα.
- Κάπνισμα - Προσπάθεια μείωσης (προκαλεί έλλειψη νικοτίνης και επιθυμία καπνίσματος) - Κάπνισμα.
- Πρωινά μαθήματα στο ΤUC - Προσπάθεια Αποφυγής - Πάλι πρωινά μαθήματα στο TUC.
- Avoid eating  junk food when writing source code (This never works actually).
- #MenoumeSpiti #covid19 -  #EtsiKiAlliosMenoumeSpiti_EimasteDevelopers #NoTreatForCovid19-#KsanamenoumeSpiti
- Βόλτα στα μαγαζιά (όταν #denMenameSpiti) - "Μωρό μου δεν έχει τίποτα εδώ που να μου πάει" -Βόλτα στα μαγαζιά.



Οτιδήποτε οδηγεί σε επαναλαμβανόμενο μοτίβο μέσω ενδιαμέσου βήματος μπορεί να εκφραστεί ώς δυνητικά looping behavior.

#### Άσκηση 7 (*Άσκηση 4.5. από βιβλίο*)

***"We saw on page 96 that the straight-line distance heuristic leads greedy best-first search astray on the problem of going from Iasi to Fagaras. However, the heuristic is perfect on the opposite problem: going from Fagaras to Iasi. Are there problems for which the heuristic is misleading in both directions?"***

<img src="C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200404102941157.png" alt="image-20200404102941157" style="zoom:80%;" />



Γενικά ένα παράδειγμα του παραπάνω φαινομένου είναι η μετάβαση $Rimnicu\space Vilcea \rightarrow Lugoj$ αφού το κοντινότερο μονοπάτι περιλαμβάνει τις $\{Mehadia,Dobreta,Craiova\} \space (νοτιότερη\space διαδρομή)$.

Παραταύτα η greedy search μέσω της ευρετικής ευθείας γραμμής (straight line heuristic)  ξεκινά λανθασμένα από την $Rimnicu \space Vilcea$ με κατεύθυνση  το $Sibiu$.

Επιπλέον ξεκινώντας από $Lugoj$ η ευρετική θα μας οδηγήσει, ορθώς, στο $Mehadia$ αλλά τότε η greedy approach επιστρέφει στο $Lugoj$ ταλαντευόμενη επ' άπειρον ανάμεσα τους.



#### Άσκηση 8 (*Άσκηση 4.14 από βιβλίο*)

**"*Suppose that an agent is in a 3 x 3 maze environment like the one shown in Figure 4.18. The agent knows that its initial location is (1,1)1, that the goal is at (3,3), and that the four actions Up, Down, Left, Right have their usual effects unless blocked by a wall. The agent does not know where the internal walls are. In any given state, the agent perceives the set of legal actions; it can also tell whether the state is one it has visited before or a new state*.** 

​		***a. Explain how this online search problem can be viewed as an offline search in belief state space, where the initial belief state includes all possible environment configurations. How large is the initial belief state? How large is the space of belief states?*** 

​		***b. How many distinct percepts are possible in the initial state?***

​		***c. Describe the first few branches of a contingency plan for this problem. How large (roughly) is the complete plan?*** 

***Notice that this contingency plan is a solution for every possible environment fitting the given description. Therefore, interleaving of search and execution is not strictly necessary even in unknown environments. "***

![image-20200404105955557](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200404105955557.png)

Στην παρούσα υπάρχει μια ελαφριά ασάφεια σχετικά αναφορικά με τον ορισμό της αντίληψης εδώ - είτε είναι απλά μια τοποθεσία ($Location$), είτε το σύνολο των επιτρεπτών κινήσεων ($unblocked\space Actions$) - οπότε θα υποτεθεί το τελευταίο για την λύση της.

Εν γένει υπάρχουν 12 πιθανές τοποθεσίες εσωτερικών τειχών άρα και $2^{12} = 4096 $ πιθανές περιβαλλοντικές διαμορφώσεις ($environment\space configurations$). 

Μια πεποίθηση πίστης  (belief state) υποδεικνύει ένα υποσύνολο πιθανών διαμορφώσεων. 

*Παράδειγμα:*

Στο αρχικό βήμα  -προτού ευρεθεί κανένας τείχος- καθεμία από τις $4096$ περιβαλλοντικές διαμορφώσεις είναι πιθανή. 





**α.** 

Μπορούμε να αντιμετωπίσουμε το παραπάνω ώς contigency problem σε έναν belief state space (χώρο καταστάσεων πίστης).

Ο αρχικός belief state space  (χώρος καταστάσεων πίστης) περιέχει $4096$ πιθανές διαμορφώσεις, ενώ ο συνολικός belief state space περιέχει $2^{4096}$ belief states για κάθε ξεχωριστό τοίχο $(*) $.

Σύμφωνα με τα παραπάνω κάθε belief state είναι πλέον πλήρως αποδομήσιμη  (decomposable) και υπάρχουν ακριβώς $3^{12}$ προσπελάσιμες belief states.

Επιπλέον ο μέγιστος αριθμός αντιλήψεων εμποδίων (wall - percepts) σε κάθε κατάσταση είναι $2^4 = 16 \implies {{actions} \over {belief\space state} } $ , $max\{ {non-deterministic\space successors \over belief\space state } \} = 16$.

**b.**

Αν τα εξωτερικά τείχη είναι γνωστά και δεν υπάρχουν εσωτερικά τότε $ 2^2 = 4$ πιθανές αντιλήψεις.

**c.**

Η αρχική μη-ενέργεια οδηγεί σε 4 πιθανές belief states. Σε κάθε μία belief state, ο πράκτορας διαλέγει μία ενέργεια $(Action)$ η οποία μπορεί να οδηγήσει σε έως και $8 $ belief states.

Δεδομένης επιπλέον της πιθανότητας επανιχνηλάτησης σε περίπτωση αδιεξόδου, ο πράκτορας μπορεί να διερευνήσει το λαβύρινθο σε έναν αριθμό $k $ βημάτων τ.ώστε: $ k \le 18$.

Οπότε και μία πιθανή λύση εκπεφρασμένη σε δενδρική μορφή δε θα είχε πάνω απο $8 ^{18}$ κόμβους.

Όμως υπάρχουν μόλις $3^{12} $ πραγματικά προσπελάσιμες καταστάσεις, οπότε μια στρατηγική επίλυσης θα μπορούσε να εκφραστεί ακόμη και σε πίνακα ενεργειών.

#### Άσκηση 9

***"Αποδείξτε ότι κάθε συνεπής ευρετική συνάρτηση είναι και παραδεκτή"***

**Συνέπεια:**

​							$h(n) ≤ c(n, a, n') + h(n')\space\space (*)$

​		όπου $c(n, a, n')$ βηματικό κόστος από $n \rightarrow n'$ μέσω ενέργειας $α$ στο $n$.

​								

**Απόδειξη:**

Έστω $k(n)$ to φθηνότερο μονοπάτι από τον κόμβο $n$ στον κόμβο στόχο $(S)$. Επαγωγικά μπορεί να δειχθεί ότι $h(n) \le k(n).$ Το παραπάνω δείχνεται ώς εξής:

- Αν υπάρχουν $0$ εναπομείναντα βήματα από τον $n$ προς τον $S$ τότε ο $n$ είναι ο $S$.

  ​									Οπότε $h(n) = 0 \le k(n)\space\space (1)$

- Έστω ότι από τον $n$ στον $S$ μεσολαβούν $i  $ βήματα, πρέπει να υπάρχει κάποιος κόμβος διαδοχής του $n$, $n'$ γεννώμενος από ενέργεια $α$ τ. ώστε:

  

  Ο $n'$ να απέχει $i-1$ βήματα από τον στόχο $\iff $$h(n) ≤ c(n, a, n' ) +h(n')\space\space(2)$ από τον ορισμό της συνέπειας$(*)$.

  ​	

  $(1)\space (όπου\space n\space το\space n')\implies h(n') \le k(n')\space\space (3)$		

  $(2),(3) \implies $	$h(n) ≤ c(n, a, n') + k(n') = k(n) \implies h(n) \le k(n)$ το οποίο είναι και το ζητούμενο.						

***SOS: Το αντίστροφο δεν ισχύει πάντα***

#### Άσκηση 10

Δίνεται: 
$$
f(n) = a*(g(n) + ε(n) ), \space \in (0,1].
$$


Πρακτικά διακρίνουμε τις εξής περιπτώσεις:
$$
α = 1 \spaceή\spaceα\in(0,1)
$$

- Εάν $α = 1$ η δοθείσα μετατρέπεται σε:

$$
f(n) = g(n) + ε(n)
$$

​		οπότε και πλέον οδηγούμαστε σε συμπεριφορά όμοια με αυτή του αλγορίθμου Α* (Α-Star Algorithm). 

​		Όπου: 

​				$g(n)$ κόστος δανειθείσας διαδρομής μέχρι n-οστό κόμβο.

​				$ε(n)$ εκτίμηση κόστους από τον n-οστό μέχρι τον κόμβο στόχο. 																					

​						

- Εάν $α \neq 1 $ η δοθείσα ανάγεται σε υποεκτίμηση του εκτιμώμενου συνολικού κόστος του μονοπατιού μέχρι το στόχο μέσω του n κόμβου.



#### Άσκηση 11

Δίνονται:

$ j_1(n) = max_i h_i(n)\space (1)$

$ j_2(n) = min_i h_i(n)\space (2)$

$ j_3(n) = \sum_{i}w_ih_i(n)\space\space όπου \sum_{i}w_i = 1\space w_i \ge 0\space (3) $

και επιπλέον:

​	$h_i =  \{h_1,h_2,h_3\}$ παραδεκτές ευρετικές.



**Αρκεί ν.δ.ο**	$j_k(n) \le h^*(n) \space,k = 1,2,3$





- Ισχύει $h_1(n) \le h^{*}(n)$ και $h_2(n) \le h^{*}(n)$ όπως και $h_3(n) \le h^{*}(n)$.

- $j_1(n) = max_i\{h_i(n)\} = argmax\{h_1,h_2,h_3\} \le h^{*}(n) \iff j_1: \space παραδεκτή\space ευρετική$.

- $j_2(n) = min_i\{h_i(n)\} = argmin\{h_1,h_2,h_3\} \le h^{*}(n) \iff j_2: \space παραδεκτή\space ευρετική$.

- $j_3(n) = \sum_{i}w_ih_i(n) = {w_1h_1 + w_2h_2 + w_3h_3}\space (4) $

  

  ​	$w_1+w_2+w_3 = 1 ,\space w_i \ge 0 \iff w_i \in (0,1)$

  $\left\{\begin{array}{l}w_k \rightarrow 0 \implies j_3 \ge min\{h_i(n)\}\}\\w_k \rightarrow 1 \implies j_3 \le max \{h_i(n)\}\end{array}\right.$	$\iff$$ min\{h_i(n)\} \le j_3 \le max\{h_1,h_2,h_3\}\space (*)$

  

  Δηλαδή η $j_3$ αποτελεί γραμμικό συνδυασμό των $h_i$ με προκαθορισμένα μεταβλητά βάρη στο $(0,1)$ .		

  $(*),(4) \implies j_3 \le h^*(n) \iff j_3:παραδεκτή\space ευρετική$.