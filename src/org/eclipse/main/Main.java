package org.eclipse.main;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.main.com.Editor;
import org.eclipse.main.cresp.Chain;
import org.eclipse.main.cresp.Number;
import org.eclipse.main.dec.*;
import org.eclipse.main.exoo.Client;
import org.eclipse.main.exoo.ClientFactory;
import org.eclipse.main.mp.NetOrder;
import org.eclipse.main.mp.OrderProcessTemplate;
import org.eclipse.main.mp.StoreOrder;
// import org.eclipse.main.obs.Editor;
import org.eclipse.main.obs.EmailNotificationListener;
import org.eclipse.main.obs.LogOpenListener;
import org.eclipse.main.pm.Forest;
import org.eclipse.main.st.Player;
import org.eclipse.main.st.UI;
import org.eclipse.main.strat.Order;
import org.eclipse.main.strat.PayByCreditCard;
import org.eclipse.main.strat.PayByPayPal;
import org.eclipse.main.strat.PayStrategy;
import org.eclipse.main.vis.*;
import org.eclipse.model.adapt.RoundHole;
import org.eclipse.model.adapt.RoundPeg;
import org.eclipse.model.adapt.SquarePeg;
import org.eclipse.model.adapt.SquarePegAdapter;
import org.eclipse.model.afab.Animal;
import org.eclipse.model.afab.AnimalFactory;
import org.eclipse.model.afab.ProviderFactory;
import org.eclipse.model.builder.User;
import org.eclipse.model.builder2.CDBuilder;
import org.eclipse.model.builder2.CDType;
import org.eclipse.model.compos.Department;
import org.eclipse.model.compos.FinancialDepartment;
import org.eclipse.model.compos.HeadDepartment;
import org.eclipse.model.compos.SalesDepartment;
import org.eclipse.model.fab.TypeUnite;
import org.eclipse.model.fab.Unite;
import org.eclipse.model.fab.Usine;
import org.eclipse.model.fab.exos.Shape;
import org.eclipse.model.fab.exos.ShapeFactory;
import org.eclipse.model.fab2.GetPlanFactory;
import org.eclipse.model.fab2.Plan;
import org.eclipse.model.mem.CareTaker;
import org.eclipse.model.mem.Originator;
import org.eclipse.model.proto.Human;
import org.eclipse.model.sing.LazySingleton;

public class Main {
	
	private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }
	
    static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 1000000;
    static int TREE_TYPES = 2;
    
    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
	
    private static void export(IShape... shapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }

	public static void main(String[] args) throws IOException {

		//	L???Observateur est un patron de conception comportemental qui permet ?? 
		//  certains objets d???envoyer des notifications concernant leur ??tat ?? d???autres objets.
		
		// Exemples d???utilisation : L???observateur est assez r??pandu en Java, surtout dans les composants GUI.
		// Il fournit une mani??re de r??agir aux ??v??nements qui se produisent chez d???autres objets sans 
		// se coupler ?? leurs classes.
		
		// Dans cet exemple, l???observateur ??tablit une collaboration indirecte entre les objets d???un 
		// ??diteur de texte. 
		// Chaque fois que l???objet ??diteur est modifi??, il envoie une notification ?? ses souscripteurs. 
		// EmailNotificationListener et LogOpenListener r??agissent ?? ces notifications en ex??cutant 
		// leurs comportements principaux.

		// Les classes du souscripteur ne sont pas coupl??es aux classes de l?????diteur et peuvent ??tre 
		// r??utilis??es dans d???autres applications si besoin. 
		// La classe ??diteur d??pend uniquement de l???interface abstraite du souscripteur. 
		// Ainsi nous pouvons ajouter de nouveaux types de souscripteurs sans modifier le code de 
		// l?????diteur.
				
//		Editor editor = new Editor();
//        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
//        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));
//
//        try {
//            editor.openFile("test.txt");
//            editor.saveFile();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        // Le Visiteur est un patron de conception comportemental qui permet d???ajouter de nouveaux 
        // comportements ?? une hi??rarchie de classes sans modifier l???existant.
        
        // Dans cet exemple, nous voulons exporter un ensemble de formes g??om??triques en XML. 
        // Le truc, c???est que nous ne voulons pas modifier le code des formes, ou tout du moins ??viter 
        // au maximum d???y toucher.

        // Au final, le visiteur va ??tablir une infrastructure qui nous permet d???ajouter 
        // n???importe quels comportements ?? la hi??rarchie des formes sans toucher au code existant 
        // de ces classes
		       
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        export(circle, compoundShape);
        
        // L?????tat est un patron de conception comportemental qui permet ?? un objet de modifier son 
        // comportement lorsque son ??tat interne change.

        // Ce patron extrait les comportements li??s aux ??tats dans des classes s??par??es et 
        // force l???objet original ?? d??l??guer les t??ches ?? une instance de ces classes, au lieu de 
        // le faire lui-m??me.
        
        // Dans cet exemple, le patron de conception ??tat permet aux touches du lecteur multim??dia 
        // d???avoir un comportement relatif ?? l?????tat actuel de la lecture. 
        // La classe principale du lecteur garde une r??f??rence vers un objet ??tat qui effectue 
        // la majeure partie du travail pour le lecteur. Certaines actions finiront par remplacer 
        // l?????tat actuel par un autre, modifiant les r??actions du lecteur face aux interactions 
        // de l???utilisateur.
        
//        Player player = new Player();
//        UI ui = new UI(player);
//        ui.init();
        
        // La Commande est un patron de conception comportemental qui convertit des demandes ou 
        // des traitements simples en objets.

        // Cette conversion permet de diff??rer ou d???ex??cuter ?? distance des commandes, 
        // de g??rer un historique de commandes, etc.
        
        // La commande est tr??s r??pandue en Java. Elle est souvent utilis??e comme une alternative 
        // aux callbacks, pour param??trer les ??l??ments d???une UI avec des actions. 
        // Elle est ??galement utilis??e pour mettre des t??ches dans une file d???attente, suivre un 
        // historique de traitements, etc.
        
        // Dans cet exemple, chaque interaction de l???utilisateur avec l?????diteur de texte cr??e 
        // de nouveaux objets commande. Apr??s avoir lanc?? toutes ses actions, une commande est 
        // pouss??e dans la pile de l???historique.

        // Pour pouvoir lancer le traitement d???annulation, l???application prend la derni??re commande 
        // ex??cut??e de l???historique et soit elle ex??cute l???action inverse, soit elle restaure 
        // l?????tat pass?? de l?????diteur qui a ??t?? sauvegard?? par cette commande.
        
//        Editor editor = new Editor();
//        editor.init();
        
        // Le poids mouche est un patron de conception structurel qui permet ?? des programmes 
        // de limiter leur consommation de m??moire malgr?? un tr??s grand nombre d???objets.

        // Ce patron est obtenu en partageant des parties de l?????tat d???un objet ?? plusieurs 
        // autres objets. 
        // En d???autres termes, le poids mouche ??conomise de la RAM en mettant en cache les 
        // donn??es identiques chez diff??rents objets.
        
        // Le poids mouche n???a qu???une seule utilit?? : minimiser la consommation de m??moire. 
        // Si votre programme ne rencontre aucun probl??me de RAM, ignorez ce patron pour le moment.
        
        // Dans cet exemple, nous allons proc??der ?? l???affichage d???une for??t (1 000 000 d???arbres)???! 
        // Chaque arbre sera repr??sent?? par son propre objet avec un certain ??tat (coordonn??es, 
        // texture, etc.). 
        // M??me si le programme remplit bien son r??le, il consomme naturellement ??norm??ment de RAM.

        // La raison est simple : de trop nombreux objets Arbre contiennent des donn??es dupliqu??es 
        // (nom, texture, couleur). 
        // Nous pouvons lui appliquer le poids mouche afin de stocker ces valeurs dans des objets 
        // poids mouche s??par??s (la classe TypeArbre). 
        // Plut??t que de stocker les m??mes donn??es des milliers de fois dans des objets Arbre, 
        // nous allons r??f??rencer un objet poids mouche avec certaines valeurs.
        
//        Forest forest = new Forest();
//        
//        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
//            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
//                    "Summer Oak", Color.GREEN, "Oak texture stub");
//            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
//                    "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
//        }
//        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
//        forest.setVisible(true);
//
//        System.out.println(TREES_TO_DRAW + " trees drawn");
//        System.out.println("---------------------");
//        System.out.println("Memory usage:");
//        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
//        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
//        System.out.println("---------------------");
//        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
//                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
        
        // Le D??corateur est un patron de conception structurel qui permet d???ajouter dynamiquement 
        // de nouveaux comportements ?? des objets en les pla??ant ?? l???int??rieur d???objets sp??ciaux 
        // appel??s emballeurs (wrappers).

        // ?? l???aide de ces d??corateurs, vous pouvez emballer des objets de nombreuses fois, puisque 
        // les objets cibl??s et les d??corateurs impl??mentent la m??me interface. 
        // L???objet final recevra tous les comportements de tous les emballeurs.
        
        // Dans cet exemple, vous allez voir comment ajuster le comportement d???un objet sans toucher 
        // ?? son code.

        // ?? la base, la classe contenant la logique m??tier ne pouvait que lire et ??crire des 
        // donn??es en texte brut. 
        // Nous avons par la suite cr???? plusieurs petites classes d???emballeurs qui ont ajout?? 
        // de nouveaux comportements en appelant des traitements standards dans un objet emball??.

        // Le premier emballeur chiffre et d??chiffre les donn??es, le second compresse et extrait 
        // les donn??es.

        // Vous pouvez m??me combiner ces emballeurs en emballant un d??corateur dans l???autre.
        
//        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
//        DataSourceDecorator encoded = new CompressionDecorator(
//                                         new EncryptionDecorator(
//                                             new FileDataSource("out/OutputDemo.txt")));
//        encoded.writeData(salaryRecords);
//        DataSource plain = new FileDataSource("out/OutputDemo.txt");
//
//        System.out.println("- Input ----------------");
//        System.out.println(salaryRecords);
//        System.out.println("- Encoded --------------");
//        System.out.println(plain.readData());
//        System.out.println("- Decoded --------------");
//        System.out.println(encoded.readData());
        
        // La Cha??ne de responsabilit?? est un patron de conception comportemental qui permet de 
        // faire circuler une demande tout au long d???une cha??ne de handlers, jusqu????? ce que l???un 
        // d???entre eux la traite.

        // Ce patron permet ?? plusieurs objets de traiter une demande sans coupler la classe 
        // du demandeur aux classes concr??tes des r??cepteurs. 
        // La cha??ne peut ??tre assembl??e dynamiquement ?? l???ex??cution ?? l???aide de tout handler 
        // impl??mentant l???interface standard des handlers.
//        
//		Chain chain = new Chain();
//		
//		chain.process(new Number(90));
//		chain.process(new Number(-50));
//		chain.process(new Number(0));
//		chain.process(new Number(91));
		
		// La Strat??gie est un patron de conception comportemental qui transforme un ensemble de 
		// comportements en objets, et les rend interchangeables ?? l???int??rieur de l???objet du contexte original.
		
		// L???objet original, que l???on appelle contexte, garde une r??f??rence vers un objet strat??gie et 
		// lui d??l??gue l???ex??cution du comportement. 
		
		// Les autres objets doivent remplacer l???objet strat??gie associ?? afin de modifier la 
		// mani??re dont le contexte fonctionne.
		
//		while (!order.isClosed()) {
//            int cost;
//
//            String continueChoice;
//            do {
//                System.out.print("Please, select a product:" + "\n" +
//                        "1 - Mother board" + "\n" +
//                        "2 - CPU" + "\n" +
//                        "3 - HDD" + "\n" +
//                        "4 - Memory" + "\n");
//                int choice = Integer.parseInt(reader.readLine());
//                cost = priceOnProducts.get(choice);
//                System.out.print("Count: ");
//                int count = Integer.parseInt(reader.readLine());
//                order.setTotalCost(cost * count);
//                System.out.print("Do you wish to continue selecting products? Y/N: ");
//                continueChoice = reader.readLine();
//            } while (continueChoice.equalsIgnoreCase("Y"));
//
//            if (strategy == null) {
//                System.out.println("Please, select a payment method:" + "\n" +
//                        "1 - PalPay" + "\n" +
//                        "2 - Credit Card");
//                String paymentMethod = reader.readLine();
//
//                // Client creates different strategies based on input from user,
//                // application configuration, etc.
//                if (paymentMethod.equals("1")) {
//                    strategy = new PayByPayPal();
//                } else {
//                    strategy = new PayByCreditCard();
//                }
//            }
//
//            // Order object delegates gathering payment data to strategy object,
//            // since only strategies know what data they need to process a
//            // payment.
//            order.processOrder(strategy);
//
//            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
//            String proceed = reader.readLine();
//            if (proceed.equalsIgnoreCase("P")) {
//                // Finally, strategy handles the payment.
//                if (strategy.pay(order.getTotalCost())) {
//                    System.out.println("Payment has been successful.");
//                } else {
//                    System.out.println("FAIL! Please, check your data.");
//                }
//                order.setClosed();
//            }
//        }
		
		// Singleton

		// Singleton garantit qu???une classe n???a qu???une seule instance et fournit un
		// point d???acc??s global ?? cette instance.

		// Certaines applications poss??dent des classes qui doivent ??tre instanci??es une
		// seule et unique fois.
		// C???est par exemple le cas d???une classe qui impl??menterait un pilote pour un
		// p??riph??rique, ou encore un syst??me de journalisation.

		// En effet, instancier deux fois une classe servant de pilote ?? une imprimante
		// provoquerait une surcharge inutile du syst??me et des comportements
		// incoh??rents.

//		System.out.println("D??marrage du programme");
//		System.out.println("Mon singleton n'est toujours pas charg?? ...");
//		System.out.println("Bon allez, je me d??cide ?? l'appeler ...");
//		LazySingleton singleton = LazySingleton.getInstance();
//		LazySingleton singleton2 = LazySingleton.getInstance();
//
//		System.out.println("Et maintenant je l'affiche ...");
//		System.out.println(singleton);
//		System.out.println(singleton2);
//
//		System.out.println("---------------------------------");

		// Depuis Java 5, un singleton peut s'impl??menter au moyen d'une ?? enum ??

		// Fabrique

		// Le design pattern Fabrique (Factory Method) d??finit une interface pour la
		// cr??ation d'un objet
		// en d??l??guant ?? ses sous-classes le choix des classes ?? instancier.

		// 1- Pour cela, nous allons d??finir une classe abstraite Unite disposant d'un
		// nom, d'un co??t de
		// construction, d'une pr??cision d'attaque, d'une facult?? d'esquive...

		// 2- Toutes les unit??s de notre jeu vont h??riter de cette classe comme par
		// exemple la classe
		// SoldatHumain et CommandantHumain en ayant chacune leurs propres sp??cificit??s

		// 3- Une classe Usine va permettre de cr??er ces unit??s gr??ce ?? la m??thode
		// formerUnite(TypeUnite).
		// La premi??re id??e qui vient ?? l'esprit pour impl??menter cette m??thode est de
		// tester le type d'unit??
		// souhait?? pass?? en param??tre et de cr??er un objet correspondant ?? l'unit??
		// demand??e.

		// 4- On peut facilement pr??voir que cette portion du code va ??tre amen?? ??
		// ??voluer lors de l'ajout de
		// nouvelles unit??s. De plus, si plusieurs b??timents diff??rents permettent de
		// cr??er des unit??s, les
		// modifications devront ??tre report?? dans plusieurs endroits du jeu.
		// Cela va donc vite devenir de plus en plus fastidieux d'ajouter des unit??s et
		// des b??timents et
		// surtout source d'erreurs en ??tant oblig?? de modifier le code existant.

		// 5- Pour r??pondre ?? cette probl??matique on va impl??menter une simple fabrique,
		// qui pour rappel est une
		// bonne pratique de conception mais pas un design pattern a proprement parl??.
		// Le principe est de regrouper
		// l'instanciation des unit??s dans une seule classe, ici SimpleFabrique, afin
		// d'??viter la duplication de
		// cette portion du code vou??e aux ??volutions.

//		Usine usine = new Usine();
//		Unite unite = usine.formerUnite(TypeUnite.SOLDAT);
//		System.out.println(unite);
//
//		System.out.println("---------------------------------");

//		GetPlanFactory planFactory = new GetPlanFactory();
//
//		System.out.print("Enter the name of plan for which the bill will be generated: ");
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		String planName = br.readLine();
//		System.out.print("Enter the number of units for bill will be calculated: ");
//		int units = Integer.parseInt(br.readLine());
//
//		Plan p = planFactory.getPlan(planName);
//		// call getRate() method and calculateBill()method of DomesticPaln.
//
//		System.out.print("Bill amount for " + planName + " of  " + units + " units is: ");
//		p.getRate();
//		p.calculateBill(units);
//
//		System.out.println("---------------------------------");
//
//		try {
//
//			ShapeFactory shapeFactory = new ShapeFactory();
//
//			Shape shape1 = shapeFactory.getShape(null);
//
//			shape1.draw();
//
//			Shape shape2 = shapeFactory.getShape("RECTANGLE");
//
//			shape2.draw();
//
//			Shape shape3 = shapeFactory.getShape("SQUARE");
//
//			shape3.draw();
//
//		} catch (Exception exception) {
//
//			System.out.println("Shape can not be null");
//
//		}
//
//		System.out.println("---------------------------------");
//
//		// Builder
//
//		// Le mod??le Builder vise ?? ?? S??parer la construction d'un objet complexe de sa
//		// repr??sentation afin que le m??me processus de construction puisse cr??er
//		// diff??rentes repr??sentations ??.
//
//		// 1- Dans la pratique normale, si nous voulons cr??er une classe User immuable,
//		// nous devons transmettre les cinq informations en tant que param??tres au
//		// constructeur.
//
//		// 2- Maintenant, que se passe-t-il si seuls firstName et lastName sont
//		// obligatoires et que les 3 autres champs
//		// sont facultatifs. Probl??me !! Nous avons besoin de plus de constructeurs.
//
//		// 3- Une fa??on est de cr??er plus de constructeurs, et une autre est de perdre
//		// l'immuabilit?? et d'introduire des m??thodes setter.
//
//		// 4- Ici, le mod??le de builder vous aidera ?? consommer des attributs
//		// suppl??mentaires tout en conservant l'immuabilit?? de la classe User.
//
//		User user1 = new User.UserBuilder("Lokesh", "Gupta").age(30).phone("1234567").address("Fake address 1234")
//				.build();
//
//		System.out.println(user1);
//
//		User user2 = new User.UserBuilder("Jack", "Reacher").age(40).phone("5655")
//				// no address
//				.build();
//
//		System.out.println(user2);
//
//		User user3 = new User.UserBuilder("Super", "Man")
//				// No age
//				// No phone
//				// no address
//				.build();
//
//		System.out.println(user3);
//
//		System.out.println("---------------------------------");
//
//		CDBuilder cdBuilder = new CDBuilder();
//		CDType cdType1 = cdBuilder.buildSonyCD();
//		cdType1.showItems();
//
//		CDType cdType2 = cdBuilder.buildSamsungCD();
//		cdType2.showItems();
//
//		System.out.println("---------------------------------");
//
		// Prototype Design Pattern Creation

		// Le mod??le de prototype est un mod??le de conception de cr??ation dans le
		// d??veloppement de logiciels. Il est utilis??
		// lorsque le type d'objets ?? cr??er est d??termin?? par une instance prototypique,
		// qui est de cloner pour produire de nouveaux objets.

//		Human human1 = new Human("Erwan", "Le Tutour", 30);
//
//		// human2 a les m??mes valeurs de propri??t??s que human1, mais elles ne seront
//		// ??gales que si j'impl??mente la m??thode equals() pour le faire.
//
//		Human human2 = (Human) human1.getClone();
//
//		System.out.println(human2);
//
//		human2.setName("Jean");
//
//		System.out.println(human2);
//
//		System.out.println("---------------------------------");
//
//		// Abstract Factory Design Pattern Creation
//
//		// Permet de cr??er des familles d???objets apparent??s sans pr??ciser leur classe
//		// concr??te.
//
		
//		Animal b = (Animal) ProviderFactory.getFactory("Animal").create("Bear", "Grizzly");
//		System.out.println("Bear :" + b.getAnimal());
//	
//		AnimalFactory a = new AnimalFactory();
//		Animal dog = a.create("Dog", "Fox");
//		
//		System.out.println("Dog :" + dog.getAnimal());
//
//		System.out.println("---------------------------------");
//
//		// Adapter Design Pattern Structure
//
//		// L???Adaptateur est un patron de conception structurel qui permet ?? des objets
//		// incompatibles de collaborer.
//
//		// L???adaptateur fait office d???emballeur entre les deux objets. Il r??cup??re les
//		// appels ?? un objet et les met dans un format et une interface reconnaissables
//		// par le second objet.
//
//		// Round fits round, no surprise.
//		RoundHole hole = new RoundHole(5);
//		RoundPeg rpeg = new RoundPeg(5);
//		if (hole.fits(rpeg)) {
//			System.out.println("Round peg r5 fits round hole r5.");
//		}
//
//		SquarePeg smallSqPeg = new SquarePeg(2);
//		SquarePeg largeSqPeg = new SquarePeg(20);
//		
//
//		// L???adaptateur peut ??tre identifi?? gr??ce ?? son constructeur qui prend une
//		// instance d???un type abstrait
//		// diff??rent ou d???une interface diff??rente. Lorsque l???une des m??thodes de
//		// l???adaptateur est appel??e,
//		// il traduit les param??tres dans un format appropri?? et redirige l???appel vers
//		// une ou plusieurs m??thodes de l???objet emball??.
//
//
//		SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
//		SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
//		if (hole.fits(smallSqPegAdapter)) {
//			System.out.println("Square peg w2 fits round hole r5.");
//		}
//		if (!hole.fits(largeSqPegAdapter)) {
//			System.out.println("Square peg w20 does not fit into round hole r5.");
//		}
//
//		System.out.println("---------------------------------");
//
//		System.out.println("---------------------------------");
//
//		// Composite Design Pattern Structure
//
//		// Le Composite est un patron de conception structurel qui permet d???agencer les
//		// objets dans une structure ressemblant ?? une arborescence, afin de pouvoir la traiter
//		// comme un objet individuel.
//
//		// Le composite est devenu la solution la plus populaire pour r??gler les
//		// probl??mes d???une structure arborescente.
//
//		// Il offre une fonctionnalit?? tr??s pratique qui permet de parcourir
//		// r??cursivement toute l???arborescence et d???additionner les r??sultats
//
//		Department salesDepartment = new SalesDepartment(1, "Sales department");
//		Department financialDepartment = new FinancialDepartment(2, "Financial department");
//
//		HeadDepartment headDepartment = new HeadDepartment(3, "Head department");
//
//		headDepartment.addDepartment(salesDepartment);
//		headDepartment.addDepartment(financialDepartment);
//
//		headDepartment.printDepartmentName();
//
//		System.out.println("---------------------------------");
//
//		// Composite Exo
//
//		Sub sub = new Sub(1300);
//		Sub sub2 = new Sub(1300);
//
//		System.out.println(sub.getCost());
//		System.out.println(sub2.getCost());
//
//		Responsable res = new Responsable(2000);
//
//		res.addSub(sub);
//		res.addSub(sub2);
//
//		System.out.println(res.getCost());
//		System.out.println(res.getCostMan());
//
//		Sub sub3 = new Sub(1400);
//		Sub sub4 = new Sub(1400);
//
//		System.out.println(sub3.getCost());
//		System.out.println(sub4.getCost());
//
//		Responsable res2 = new Responsable(2000);
//
//		res2.addSub(sub3);
//		res2.addSub(sub4);
//
//		System.out.println(res2.getCost());
//		System.out.println(res2.getCostMan());
//
//		Vip vip = new Vip(2500);
//
//		vip.addRes(res);
//		vip.addRes(res2);
//
//		System.out.println(vip.getCostMan());
//
//		Ceo ceo = new Ceo(4000);
//
//		ceo.addVip(vip);
//
//		System.out.println(ceo.getCostMan());
//		
//		System.out.println("---------------------------------");
//		
//		// Memento Design Pattern Comportement
//
//		// Le M??mento est un patron de conception comportemental qui permet de prendre
//		// des instantan??s de l?????tat d???un objet et de les restaurer plus tard.
//
//		// Le mod??le Memento utilise trois classes d'acteurs.
//
//		// Memento contient l'??tat d'un objet ?? restaurer.
//		// Originator cr??e et stocke les ??tats dans les objets Memento
//		// L'objet Caretaker est charg?? de restaurer l'??tat de l'objet ?? partir de
//		// Memento.
//
//		// On utilise CareTaker et Originator pour montrer la restauration des ??tats des
//		// objets.
//
//		Originator originator = new Originator();
//		CareTaker careTaker = new CareTaker();
//
//		originator.setState("State #1");
//		originator.setState("State #2");
//		careTaker.add(originator.saveStateToMemento());
//
//		originator.setState("State #3");
//		careTaker.add(originator.saveStateToMemento());
//
//		originator.setState("State #4");
//		System.out.println("Current State: " + originator.getState());
//
//		originator.getStateFromMemento(careTaker.get(0));
//		System.out.println("First saved State: " + originator.getState());
//		originator.getStateFromMemento(careTaker.get(1));
//		System.out.println("Second saved State: " + originator.getState());
//		
//		System.out.println("---------------------------------");
//
//		// Iterator Design Pattern Comportement
//
//		// Iterator est une interface qui appartient au framework collection.
//		// Il nous permet de parcourir la collection, d???acc??der ?? l?????l??ment et supprimer
//		// les ??l??ments de la collection. 
//		// Le package java.util a une interface publique Iterator etvcontient 3 m??thodes:
//
//		// boolean hasNext(): il retourne true si Iterator a plus d?????l??ment ?? it??rer.
//		// Object next(): il retourne l?????l??ment suivant dans la collection jusqu????? ce
//		// que la m??thode hasNext() retourne true. 
//		// Cette m??thode l??ve ???NoSuchElementException??? s???il n???y a pas d?????l??ment suivant.
//		// void remove(): Il supprime l?????l??ment courant de la collection.
//		// Cette m??thode l??ve ???IllegalStateException??? si cette fonction est appel??e
//		// avant que next() soit invoqu??.
//
//		List<String> color = new ArrayList<>(Arrays.asList("Blue", "Red", "Green"));
//		Iterator<String> it = color.iterator();
//		
//		// Afficher le premier
//		// System.out.println(it.next());
//
//		while (it.hasNext()) {
//			// System.out.println(it.next());
//			String i = it.next();
//			if(i.startsWith("B")) {
//				it.remove();
//				it.next();
//			}
//		}
//		
//		System.out.println(color);
//
//		System.out.println("---------------------------------");
//
//		// ListIterator
//
//		// ListIterator en Java est un Iterator qui permet aux utilisateurs de parcourir
//		// une Collection dans les deux sens. Il contient les m??thodes suivantes:
//
//		// void add(Object object): il ins??re un objet juste avant l?????l??ment renvoy?? par
//		// la m??thode next().
//		// boolean hasNext(): il retourne true si la liste a un ??l??ment suivant.
//		// boolean hasPrevious(): il retourne true si la liste a un ??l??ment pr??c??dent.
//		// Object next(): il retourne l?????l??ment suivant de la liste. Il l??ve
//		// ???NoSuchElementException???
//		// s???il n???y a pas d?????l??ment suivant dans la liste.
//		// Object previous(): il retourne l?????l??ment pr??c??dent de la liste. Il l??ve
//		// ???NoSuchElementException???
//		// s???il n???y a pas d?????l??ment pr??c??dent.
//		// void remove(): Il supprime l?????l??ment courant de la liste. Il l??ve
//		// ???IllegalStateException???
//		// si cette fonction est appel??e avant que next() ou previous() soit invoqu??.
//
//		ArrayList<String> lang = new ArrayList<String>();
//		lang.add("Java");
//		lang.add("Python");
//		lang.add("PHP");
//		lang.add("C++");
//		lang.add("Perl");
//
//		// ListIterator pour parcourir la liste
//		ListIterator<String> iterator = lang.listIterator();
//
//		// Parcourant la liste en avant
//		System.out.println("Parcours en avant : ");
//		while (iterator.hasNext())
//			System.out.println(iterator.next() + " ");
//
//		// Parcourant la liste en arri??re
//		System.out.println("Parcours en arri??re : ");
//		while (iterator.hasPrevious())
//			System.out.println(iterator.previous() + " ");
//
//		System.out.println("---------------------------------");
		
//		OrderProcessTemplate netOrder = new NetOrder();
//        netOrder.processOrder(true);
//        System.out.println();
//        OrderProcessTemplate storeOrder = new StoreOrder();
//        storeOrder.processOrder(true);
//        
//        
//        
//        
//        
//        
//        
//        System.out.println("---------------------------------");
//        
//		ClientFactory cFactory = new ClientFactory();
//
//		Client clientDebit = cFactory.getClient("ClDe");
//
//		clientDebit.creerCarte();
//
//		Client clientCredit = cFactory.getClient("ClCr");
//
//		clientCredit.creerCarte();

	}

}
