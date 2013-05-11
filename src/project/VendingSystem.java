package project;
import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a container for vending machines, along with functionality to 
 * reach out and access those machine.
 * machines
 * @author FTM
 */
public class VendingSystem implements Serializable{
	
	//List of all vending machines in the system
	public ArrayList<VendingMachine> machines = new ArrayList<VendingMachine>();
	
	//A list of valid manager profiles
	private  ArrayList<Manager> managerList = new ArrayList<Manager>();
	//A list of valid restocker profiles
	private  ArrayList<Restocker> restockerList = new ArrayList<Restocker>();
	
	//The statistics container for the system
	public  Statistics stats = new Statistics();
	
	public TreeMap<String, Integer> itemsList = new TreeMap<String, Integer>();
	public long startTime = (System.nanoTime()/1000000000)/60;
	
	/**
	 * Makes a pre-filled machine system (for testing purposes)
	 */
	public VendingSystem(){
		// Creates and loads the itemsList()
		initalizeItemList();
		
		//Adds the default manager and restocker profiles
		restockerList.add(new Restocker("restocker1", "password"));
		restockerList.add(new Restocker("ajl2612", "password"));
		restockerList.add(new Restocker("dxkvse", "password"));
		managerList.add(new Manager("manager1", "password"));
		managerList.add(new Manager("ajl2612", "password"));
		managerList.add(new Manager("dxkvse", "password"));
		
		//ItemLists
		ArrayList<Item> initialItems1 = new ArrayList<Item>();
		ArrayList<Item> initialItems2 = new ArrayList<Item>();
		ArrayList<Item> initialItems3 = new ArrayList<Item>();
		ArrayList<Item> initialItems4 = new ArrayList<Item>();
		ArrayList<Item> initialItems5 = new ArrayList<Item>();
		ArrayList<Item> initialItems6 = new ArrayList<Item>();
		
		//Initial Expiration lists and Items
		ArrayList<Integer> testSnickers; Item snickers;
		ArrayList<Integer> testMilkyWay; Item milkyWay;
		ArrayList<Integer> testButterfinger; Item butterfinger;
		ArrayList<Integer> test3Musketeers; Item musketeers;
		ArrayList<Integer> testMnMs; Item MnMs;
		ArrayList<Integer> testCrunch; Item crunch;
		ArrayList<Integer> testPayDay; Item payDay;
		ArrayList<Integer> testKitKat; Item kitKat;
		ArrayList<Integer> testReeses; Item reeses;
		ArrayList<Integer> testTwizzlers; Item twizzlers;
		ArrayList<Integer> testFiberOne; Item fiberOne;
		ArrayList<Integer> testPoptart; Item poptart;
		ArrayList<Integer> testSkittles; Item skittles;
		ArrayList<Integer> testBabyRuth; Item babyRuth;
		ArrayList<Integer> testHersheys; Item hersheys;
		ArrayList<Integer> testTwix; Item twix;
		ArrayList<Integer> testDoritos; Item doritos;
		ArrayList<Integer> testSunChips; Item sunChips;
		ArrayList<Integer> testLays; Item lays;
		ArrayList<Integer> testCheezIt; Item cheezIt;
		ArrayList<Integer> testRiceKrispies; Item riceKrispies;
		ArrayList<Integer> testCheetos; Item cheetos;
		ArrayList<Integer> testFritos; Item fritos;
		ArrayList<Integer> testCombos; Item combos;
		ArrayList<Integer> testSourPatch; Item sourPatch;
		ArrayList<Integer> testSweedishFish; Item sweedishFish;
		ArrayList<Integer> testBeefJerky; Item beefJerky;
		ArrayList<Integer> testWater; Item water;
		ArrayList<Integer> testPepsi; Item pepsi;
		ArrayList<Integer> testMountainDew; Item mountainDew;
		ArrayList<Integer> testRootbeer; Item rootbeer;
		ArrayList<Integer> testAMP; Item amp;
		ArrayList<Integer> testSobe; Item sobe;
		ArrayList<Integer> testRedBull; Item redBull;
		ArrayList<Integer> testGatorade; Item gatorade;
		ArrayList<Integer> testOrangeJuice; Item orangeJuice;
		ArrayList<Integer> testAppleJuice; Item appleJuice;
		Item empty;
		
		
		
		///////////////////////////////////////////////////////////
		//
		// 		Vending Machine 1 
		//
		// initialItems1 (5 x 5 x 5), no qualities [expires around 30]
		//
		testSnickers = new ArrayList<Integer>();
		testSnickers.add(25); testSnickers.add(25); testSnickers.add(25); testSnickers.add(30); testSnickers.add(30);
		testMilkyWay = new ArrayList<Integer>();
		testMilkyWay.add(35); testMilkyWay.add(35); testMilkyWay.add(35); testMilkyWay.add(35); testMilkyWay.add(35);
		testButterfinger = new ArrayList<Integer>();
		testButterfinger.add(30); testButterfinger.add(30); testButterfinger.add(30); testButterfinger.add(30); testButterfinger.add(30);
		test3Musketeers = new ArrayList<Integer>();
		test3Musketeers.add(25); test3Musketeers.add(25); test3Musketeers.add(25); test3Musketeers.add(30); test3Musketeers.add(30);
		testMnMs = new ArrayList<Integer>();
		testMnMs.add(35); testMnMs.add(35); testMnMs.add(35); testMnMs.add(35); testMnMs.add(35);
		testCrunch = new ArrayList<Integer>();
		testCrunch.add(35); testCrunch.add(35); testCrunch.add(35);
		testPayDay = new ArrayList<Integer>();
		testPayDay.add(25); testPayDay.add(25); testPayDay.add(25); testPayDay.add(30); testPayDay.add(30);
		testKitKat = new ArrayList<Integer>();
		testKitKat.add(25); testKitKat.add(25); testKitKat.add(25); testKitKat.add(30); testKitKat.add(30);
		testReeses = new ArrayList<Integer>();
		testReeses.add(40); testReeses.add(40); testReeses.add(40); testReeses.add(40); testReeses.add(40);
		testHersheys = new ArrayList<Integer>();
		testHersheys.add(40); testHersheys.add(40); testHersheys.add(40); testHersheys.add(40); testHersheys.add(40);
		testSkittles = new ArrayList<Integer>();
		testSkittles.add(15); testSkittles.add(15); testSkittles.add(35); testSkittles.add(35); testSkittles.add(35);
		testTwix = new ArrayList<Integer>();
		testTwix.add(20); testTwix.add(20); testTwix.add(20); testTwix.add(20); testTwix.add(20);
		testTwizzlers = new ArrayList<Integer>();
		testTwizzlers.add(30); testTwizzlers.add(30); testTwizzlers.add(30); testTwizzlers.add(30); testTwizzlers.add(30);
		testDoritos = new ArrayList<Integer>();
		testDoritos.add(30); testDoritos.add(30); testDoritos.add(30); testDoritos.add(30); testDoritos.add(30);
		testCheetos = new ArrayList<Integer>();
		testCheetos.add(35); testCheetos.add(35); testCheetos.add(35); testCheetos.add(35); testCheetos.add(35);
		testCombos = new ArrayList<Integer>();
		testCombos.add(35); testCombos.add(35); testCombos.add(35); testCombos.add(35); testCombos.add(35);
		testSourPatch = new ArrayList<Integer>();
		testSourPatch.add(35); testSourPatch.add(35); testSourPatch.add(35); testSourPatch.add(35); testSourPatch.add(35);
		testLays = new ArrayList<Integer>();
		testLays.add(40); testLays.add(40); testLays.add(40); testLays.add(40); testLays.add(40);
		testCheezIt = new ArrayList<Integer>();
		testCheezIt.add(40); testCheezIt.add(40); testCheezIt.add(40); testCheezIt.add(40); testCheezIt.add(40);
		testWater = new ArrayList<Integer>();
		testWater.add(1000000); testWater.add(1000000); testWater.add(1000000); testWater.add(1000000); testWater.add(1000000);
		testPepsi = new ArrayList<Integer>();
		testPepsi.add(120); testPepsi.add(120); testPepsi.add(120); testPepsi.add(120); testPepsi.add(120);
		testRootbeer = new ArrayList<Integer>();
		testRootbeer.add(120); testRootbeer.add(120); testRootbeer.add(120); testRootbeer.add(120); testRootbeer.add(120);
		testGatorade = new ArrayList<Integer>();
		testGatorade.add(120); testGatorade.add(120); testGatorade.add(120); testGatorade.add(120); testGatorade.add(120);
		testRedBull = new ArrayList<Integer>();
		testRedBull.add(100); testRedBull.add(100); testRedBull.add(100); testRedBull.add(100); testRedBull.add(100);
		
		
		
		//ITEMS
		//Item(<name>, <itemID>, <currentNum>, <cost>, ArrayList<Integer> expDates)
		snickers = new Item("Snickers", 1, 5, 1.00, testSnickers);
		initialItems1.add(snickers);
		milkyWay = new Item("MilkyWay", 2, 5, 1.00, testMilkyWay);
		initialItems1.add(milkyWay);
		butterfinger = new Item("Butterfinger", 3, 5, 1.00, testButterfinger);
		initialItems1.add(butterfinger);
		musketeers = new Item("3 Musketeers", 4, 5, 1.00, test3Musketeers);
		initialItems1.add(musketeers);
		MnMs = new Item("M&M's", 5, 5, 1.25, testMnMs);
		initialItems1.add(MnMs);
		crunch = new Item("Crunch", 6, 3, 1.00, testCrunch);
		initialItems1.add(crunch);
		payDay = new Item("Pay Day", 7, 5, 1.00, testPayDay);
		initialItems1.add(payDay);
		kitKat = new Item("Kit Kat", 8, 5, 0.75, testKitKat);
		initialItems1.add(kitKat);
		reeses = new Item("Reeses", 9, 5, 0.75, testReeses);
		initialItems1.add(reeses);
		hersheys = new Item("Hersheys", 15, 5, 1.00, testHersheys);
		initialItems1.add(hersheys);
		skittles = new Item("Skittles", 13, 5, 1.00, testSkittles);
		initialItems1.add(skittles);
		twix = new Item("Twix", 16, 5, 1.00, testTwix);
		initialItems1.add(twix);
		twizzlers = new Item("Twizzler", 10, 5, 1.25, testTwizzlers);
		initialItems1.add(twizzlers);
		doritos = new Item("Doritos", 20, 5, 1.50, testDoritos);
		initialItems1.add(doritos);
		cheetos = new Item("Cheetos", 25, 5, 1.50, testCheetos);
		initialItems1.add(cheetos);
		combos = new Item("Combos", 27, 5, 1.50, testCombos);
		initialItems1.add(combos);
		sourPatch = new Item("Sour Patch", 28, 5, 1.50, testSourPatch);
		initialItems1.add(sourPatch);
		lays = new Item("Lays", 22, 5, 1.25, testLays);
		initialItems1.add(lays);
		cheezIt = new Item("Cheez-Its", 23, 5, 1.25, testCheezIt);
		initialItems1.add(cheezIt);
		empty = new Item();
		initialItems1.add(empty);
		water = new Item("Water", 40, 5, 1.00, testWater);
		initialItems1.add(water);
		pepsi = new Item("Pepsi", 41, 5, 1.75, testPepsi);
		initialItems1.add(pepsi);
		rootbeer = new Item("Rootbeer", 43, 5, 1.75, testRootbeer);
		initialItems1.add(rootbeer);
		gatorade = new Item("Gatorade", 47, 5, 1.50, testGatorade);
		initialItems1.add(gatorade);
		redBull = new Item("Red Bull", 46, 5, 2.00, testRedBull);
		initialItems1.add(redBull);
		
		VendingMachine machine1 = new VendingMachine(0, 5, 5, 5, 10.00, initialItems1, startTime);
		addNewMachine(machine1);
		machines.get(0).setRestockerReport("test.csv");
		
		///////////////////////////////////////////////////////////
		//
		// 		Vending Machine 2
		//
		// initialItems2 (3 x 2 x 4), small with quick expirations [expires around 5-15]
		//
		testFiberOne = new ArrayList<Integer>();
		testFiberOne.add(10); testFiberOne.add(10); testFiberOne.add(10); testFiberOne.add(10);
		testPoptart = new ArrayList<Integer>();
		testPoptart.add(0); testPoptart.add(10); testPoptart.add(15); testPoptart.add(15);
		testBabyRuth = new ArrayList<Integer>();
		testBabyRuth.add(3); testBabyRuth.add(3); testBabyRuth.add(3); testBabyRuth.add(3);
		testFritos = new ArrayList<Integer>();
		testFritos.add(15);
		testSunChips = new ArrayList<Integer>();
		testSunChips.add(1); testSunChips.add(20); testSunChips.add(20); testSunChips.add(20);
		testWater = new ArrayList<Integer>();
		testWater.add(1000000); testWater.add(1000000); testWater.add(1000000); testWater.add(1000000);
		
		fiberOne = new Item("Fiber One", 11, 4, 1.00, testFiberOne);
		initialItems2.add(fiberOne);
		poptart = new Item("Poptart", 12, 4, 1.50, testPoptart);
		initialItems2.add(poptart);
		babyRuth = new Item("Baby Ruth", 14, 4, 1.00, testBabyRuth);
		initialItems2.add(babyRuth);
		fritos = new Item("Fritos", 26, 1, 1.25, testFritos);
		initialItems2.add(fritos);
		sunChips = new Item("Sun Chips", 21, 4, 1.00, testSunChips);
		initialItems2.add(sunChips);
		water = new Item("Water", 40, 4, 1.00, testWater);
		initialItems2.add(water);
		
		VendingMachine machine2 = new VendingMachine(1, 3, 2, 4, 10.00, initialItems2, startTime);
		addNewMachine(machine2);
		
		///////////////////////////////////////////////////////////
		//
		// 		Vending Machine 3
		//
		// initialItems3 (3 x 3 x 10), depth of 10 [expires around 60]
		//
		testRiceKrispies = new ArrayList<Integer>();
		testRiceKrispies.add(60); testRiceKrispies.add(60); testRiceKrispies.add(60); testRiceKrispies.add(60); testRiceKrispies.add(60);
		testRiceKrispies.add(60); testRiceKrispies.add(60); testRiceKrispies.add(60); testRiceKrispies.add(60); testRiceKrispies.add(60);
		testSweedishFish = new ArrayList<Integer>();
		testSweedishFish.add(60); testSweedishFish.add(60); testSweedishFish.add(60); testSweedishFish.add(60); testSweedishFish.add(60);
		testSweedishFish.add(60); testSweedishFish.add(60); testSweedishFish.add(60); testSweedishFish.add(60); testSweedishFish.add(60);
		testBeefJerky = new ArrayList<Integer>();
		testBeefJerky.add(60); testBeefJerky.add(60); testBeefJerky.add(60); testBeefJerky.add(60); testBeefJerky.add(60);
		testBeefJerky.add(60); testBeefJerky.add(60); testBeefJerky.add(60); testBeefJerky.add(60); testBeefJerky.add(60);
		testMountainDew = new ArrayList<Integer>();
		testMountainDew.add(60); testMountainDew.add(60); testMountainDew.add(60); testMountainDew.add(60); testMountainDew.add(60);
		testMountainDew.add(60); testMountainDew.add(60); testMountainDew.add(60); testMountainDew.add(60); testMountainDew.add(60);
		testAMP = new ArrayList<Integer>();
		testAMP.add(60); testAMP.add(60); testAMP.add(60); testAMP.add(60); testAMP.add(60);
		testAMP.add(60); testAMP.add(60); testAMP.add(60); testAMP.add(60); testAMP.add(60);
		testSobe = new ArrayList<Integer>();
		testSobe.add(60); testSobe.add(60); testSobe.add(60); testSobe.add(60); testSobe.add(60);
		testSobe.add(60); testSobe.add(60); testSobe.add(60); testSobe.add(60); testSobe.add(60);
		testOrangeJuice = new ArrayList<Integer>();
		testOrangeJuice.add(60); testOrangeJuice.add(60); testOrangeJuice.add(60); testOrangeJuice.add(60); testOrangeJuice.add(60);
		testOrangeJuice.add(60); testOrangeJuice.add(60); testOrangeJuice.add(60); testOrangeJuice.add(60); testOrangeJuice.add(60);
		testAppleJuice = new ArrayList<Integer>();
		testAppleJuice.add(60); testAppleJuice.add(60); testAppleJuice.add(60); testAppleJuice.add(60); testAppleJuice.add(60);
		testAppleJuice.add(60); testAppleJuice.add(60); testAppleJuice.add(60); testAppleJuice.add(60); testAppleJuice.add(60);
		
		riceKrispies = new Item("Rice Krispies", 24, 10, 1.00, testRiceKrispies);
		initialItems3.add(riceKrispies);
		sweedishFish = new Item("Sweedish Fish", 29, 10, 1.50, testSweedishFish);
		initialItems3.add(sweedishFish);
		beefJerky = new Item("Beef Jerky", 30, 10, 2.00, testBeefJerky);
		initialItems3.add(beefJerky);
		mountainDew = new Item("Mountain Dew", 42, 10, 1.75, testMountainDew);
		initialItems3.add(mountainDew);
		amp = new Item("AMP", 44, 10, 1.50, testAMP);
		initialItems3.add(amp);
		sobe = new Item("Sobe", 45, 10, 1.50, testSobe);
		initialItems3.add(sobe);
		orangeJuice = new Item("Orange Juice", 48, 10, 1.50, testOrangeJuice);
		initialItems3.add(orangeJuice);
		appleJuice = new Item("Apple Juice", 49, 10, 1.50, testAppleJuice);
		initialItems3.add(appleJuice);
		empty = new Item();
		initialItems3.add(empty);
		
		VendingMachine machine3 = new VendingMachine(2, 3, 3, 10, 10.00, initialItems3, startTime);
		addNewMachine(machine3);
		
		///////////////////////////////////////////////////////////
		//
		// 		Vending Machine 4
		//
		// initialItems3 (8 x 5 x 5), large machine, all items [expires around 120]
		//
		testSnickers = new ArrayList<Integer>();
		testSnickers.add(120); testSnickers.add(120); testSnickers.add(120); testSnickers.add(120); testSnickers.add(120);
		testMilkyWay = new ArrayList<Integer>();
		testMilkyWay.add(120); testMilkyWay.add(120); testMilkyWay.add(120); testMilkyWay.add(120); testMilkyWay.add(120);
		testButterfinger = new ArrayList<Integer>();
		testButterfinger.add(120); testButterfinger.add(120); testButterfinger.add(120); testButterfinger.add(120); testButterfinger.add(120);
		test3Musketeers = new ArrayList<Integer>();
		test3Musketeers.add(120); test3Musketeers.add(120); test3Musketeers.add(120); test3Musketeers.add(120); test3Musketeers.add(120);
		testMnMs = new ArrayList<Integer>();
		testMnMs.add(120); testMnMs.add(120); testMnMs.add(120); testMnMs.add(120); testMnMs.add(120);
		testCrunch = new ArrayList<Integer>();
		testCrunch.add(120); testCrunch.add(120); testCrunch.add(120); testCrunch.add(120); testCrunch.add(120);
		testPayDay = new ArrayList<Integer>();
		testPayDay.add(120); testPayDay.add(120); testPayDay.add(120); testPayDay.add(120); testPayDay.add(120);
		testKitKat = new ArrayList<Integer>();
		testKitKat.add(120); testKitKat.add(120); testKitKat.add(120); testKitKat.add(120); testKitKat.add(120);
		testReeses = new ArrayList<Integer>();
		testReeses.add(120); testReeses.add(120); testReeses.add(120); testReeses.add(120); testReeses.add(120);
		testHersheys = new ArrayList<Integer>();
		testHersheys.add(120); testHersheys.add(120); testHersheys.add(120); testHersheys.add(120); testHersheys.add(120);
		testSkittles = new ArrayList<Integer>();
		testSkittles.add(120); testSkittles.add(120); testSkittles.add(120); testSkittles.add(120); testSkittles.add(120);
		testTwix = new ArrayList<Integer>();
		testTwix.add(120); testTwix.add(120); testTwix.add(120); testTwix.add(120); testTwix.add(120);
		testTwizzlers = new ArrayList<Integer>();
		testTwizzlers.add(120); testTwizzlers.add(120); testTwizzlers.add(120); testTwizzlers.add(120); testTwizzlers.add(120);
		testDoritos = new ArrayList<Integer>();
		testDoritos.add(120); testDoritos.add(120); testDoritos.add(120); testDoritos.add(120); testDoritos.add(120);
		testCheetos = new ArrayList<Integer>();
		testCheetos.add(120); testCheetos.add(120); testCheetos.add(120); testCheetos.add(120); testCheetos.add(120);
		testCombos = new ArrayList<Integer>();
		testCombos.add(120); testCombos.add(120); testCombos.add(120); testCombos.add(120); testCombos.add(120);
		testSourPatch = new ArrayList<Integer>();
		testSourPatch.add(120); testSourPatch.add(120); testSourPatch.add(120); testSourPatch.add(120); testSourPatch.add(120);
		testLays = new ArrayList<Integer>();
		testLays.add(120); testLays.add(120); testLays.add(120); testLays.add(120); testLays.add(120);
		testCheezIt = new ArrayList<Integer>();
		testCheezIt.add(40); testCheezIt.add(120); testCheezIt.add(120); testCheezIt.add(120); testCheezIt.add(120);
		testWater = new ArrayList<Integer>();
		testWater.add(1000000); testWater.add(1000000); testWater.add(1000000); testWater.add(1000000); testWater.add(1000000);
		testPepsi = new ArrayList<Integer>();
		testPepsi.add(120); testPepsi.add(120); testPepsi.add(120); testPepsi.add(120); testPepsi.add(120);
		testRootbeer = new ArrayList<Integer>();
		testRootbeer.add(120); testRootbeer.add(120); testRootbeer.add(120); testRootbeer.add(120); testRootbeer.add(120);
		testGatorade = new ArrayList<Integer>();
		testGatorade.add(120); testGatorade.add(120); testGatorade.add(120); testGatorade.add(120); testGatorade.add(120);
		testRedBull = new ArrayList<Integer>();
		testRedBull.add(120); testRedBull.add(120); testRedBull.add(120); testRedBull.add(120); testRedBull.add(120);
		testFiberOne = new ArrayList<Integer>();
		testFiberOne.add(120); testFiberOne.add(120); testFiberOne.add(120); testFiberOne.add(120); testFiberOne.add(120);
		testPoptart = new ArrayList<Integer>();
		testPoptart.add(120); testPoptart.add(120); testPoptart.add(120); testPoptart.add(120); testPoptart.add(120);
		testBabyRuth = new ArrayList<Integer>();
		testBabyRuth.add(120); testBabyRuth.add(120); testBabyRuth.add(120); testBabyRuth.add(120); testBabyRuth.add(120);
		testFritos = new ArrayList<Integer>();
		testFritos.add(120); testFritos.add(120); testFritos.add(120); testFritos.add(120); testFritos.add(120);
		testSunChips = new ArrayList<Integer>();
		testSunChips.add(120); testSunChips.add(120); testSunChips.add(120); testSunChips.add(20); testSunChips.add(20);
		testRiceKrispies = new ArrayList<Integer>();
		testRiceKrispies.add(120); testRiceKrispies.add(120); testRiceKrispies.add(120); testRiceKrispies.add(120); testRiceKrispies.add(120);
		testSweedishFish = new ArrayList<Integer>();
		testSweedishFish.add(120); testSweedishFish.add(120); testSweedishFish.add(120); testSweedishFish.add(120); testSweedishFish.add(120);
		testBeefJerky = new ArrayList<Integer>();
		testBeefJerky.add(120); testBeefJerky.add(120); testBeefJerky.add(120); testBeefJerky.add(120); testBeefJerky.add(120);
		testMountainDew = new ArrayList<Integer>();
		testMountainDew.add(120); testMountainDew.add(120); testMountainDew.add(120); testMountainDew.add(120); testMountainDew.add(120);
		testAMP = new ArrayList<Integer>();
		testAMP.add(120); testAMP.add(120); testAMP.add(120); testAMP.add(120); testAMP.add(120);
		testSobe = new ArrayList<Integer>();
		testSobe.add(120); testSobe.add(120); testSobe.add(120); testSobe.add(120); testSobe.add(120);
		testOrangeJuice = new ArrayList<Integer>();
		testOrangeJuice.add(120); testOrangeJuice.add(120); testOrangeJuice.add(120); testOrangeJuice.add(120); testOrangeJuice.add(120);
		testAppleJuice = new ArrayList<Integer>();
		testAppleJuice.add(120); testAppleJuice.add(120); testAppleJuice.add(120); testAppleJuice.add(120); testAppleJuice.add(120);
		
		snickers = new Item("Snickers", 1, 5, 1.00, testSnickers);
		initialItems4.add(snickers);
		milkyWay = new Item("MilkyWay", 2, 5, 1.00, testMilkyWay);
		initialItems4.add(milkyWay);
		butterfinger = new Item("Butterfinger", 3, 5, 1.00, testButterfinger);
		initialItems4.add(butterfinger);
		musketeers = new Item("3 Musketeers", 4, 5, 1.00, test3Musketeers);
		initialItems4.add(musketeers);
		MnMs = new Item("M&M's", 5, 5, 1.25, testMnMs);
		initialItems4.add(MnMs);
		crunch = new Item("Crunch", 6, 5, 1.00, testCrunch);
		initialItems4.add(crunch);
		payDay = new Item("Pay Day", 7, 5, 1.00, testPayDay);
		initialItems4.add(payDay);
		kitKat = new Item("Kit Kat", 8, 5, 0.75, testKitKat);
		initialItems4.add(kitKat);
		reeses = new Item("Reeses", 9, 5, 0.75, testReeses);
		initialItems4.add(reeses);
		twizzlers = new Item("Twizzler", 10, 5, 1.25, testTwizzlers);
		initialItems4.add(twizzlers);
		fiberOne = new Item("Fiber One", 11, 5, 1.00, testFiberOne);
		initialItems4.add(fiberOne);
		poptart = new Item("Poptart", 12, 5, 1.50, testPoptart);
		initialItems4.add(poptart);
		skittles = new Item("Skittles", 13, 5, 1.00, testSkittles);
		initialItems4.add(skittles);
		babyRuth = new Item("Baby Ruth", 14, 5, 1.00, testBabyRuth);
		initialItems4.add(babyRuth);
		hersheys = new Item("Hersheys", 15, 5, 1.00, testHersheys);
		initialItems4.add(hersheys);
		twix = new Item("Twix", 16, 5, 1.00, testTwix);
		initialItems4.add(twix);
		doritos = new Item("Doritos", 20, 5, 1.50, testDoritos);
		initialItems4.add(doritos);
		sunChips = new Item("Sun Chips", 21, 5, 1.00, testSunChips);
		initialItems4.add(sunChips);
		lays = new Item("Lays", 22, 5, 1.25, testLays);
		initialItems4.add(lays);
		cheezIt = new Item("Cheez-Its", 23, 5, 1.25, testCheezIt);
		initialItems4.add(cheezIt);
		riceKrispies = new Item("Rice Krispies", 24, 5, 1.00, testRiceKrispies);
		initialItems4.add(riceKrispies);
		cheetos = new Item("Cheetos", 25, 5, 1.50, testCheetos);
		initialItems4.add(cheetos);
		fritos = new Item("Fritos", 26, 5, 1.25, testFritos);
		initialItems4.add(fritos);
		combos = new Item("Combos", 27, 5, 1.50, testCombos);
		initialItems4.add(combos);
		sourPatch = new Item("Sour Patch", 28, 5, 1.50, testSourPatch);
		initialItems4.add(sourPatch);
		sweedishFish = new Item("Sweedish Fish", 29, 5, 1.50, testSweedishFish);
		initialItems4.add(sweedishFish);
		beefJerky = new Item("Beef Jerky", 30, 5, 2.00, testBeefJerky);
		initialItems4.add(beefJerky);
		empty = new Item();
		initialItems4.add(empty);
		empty = new Item();
		initialItems4.add(empty);
		empty = new Item();
		initialItems4.add(empty);
		water = new Item("Water", 40, 5, 1.00, testWater);
		initialItems4.add(water);
		pepsi = new Item("Pepsi", 41, 5, 1.75, testPepsi);
		initialItems4.add(pepsi);
		mountainDew = new Item("Mountain Dew", 42, 5, 1.75, testMountainDew);
		initialItems4.add(mountainDew);
		rootbeer = new Item("Rootbeer", 43, 5, 1.75, testRootbeer);
		initialItems4.add(rootbeer);
		amp = new Item("AMP", 44, 5, 1.50, testAMP);
		initialItems4.add(amp);
		sobe = new Item("Sobe", 45, 5, 1.50, testSobe);
		initialItems4.add(sobe);
		redBull = new Item("Red Bull", 46, 5, 2.00, testRedBull);
		initialItems4.add(redBull);
		gatorade = new Item("Gatorade", 47, 5, 1.50, testGatorade);
		initialItems4.add(gatorade);
		orangeJuice = new Item("Orange Juice", 48, 5, 1.50, testOrangeJuice);
		initialItems4.add(orangeJuice);
		appleJuice = new Item("Apple Juice", 49, 5, 1.50, testAppleJuice);
		initialItems4.add(appleJuice);
		
		VendingMachine machine4 = new VendingMachine(3, 8, 5, 5, 10.00, initialItems4, startTime);
		addNewMachine(machine4);
		
		///////////////////////////////////////////////////////////
		//
		// 		Vending Machine 5
		//
		// initialItems3 (1 x 10 x 5), testing columns  [expires around 20]
		//
		
		testMilkyWay = new ArrayList<Integer>();
		testMilkyWay.add(20); testMilkyWay.add(20); testMilkyWay.add(20); testMilkyWay.add(20); testMilkyWay.add(20);
		testButterfinger = new ArrayList<Integer>();
		testButterfinger.add(20); testButterfinger.add(20); testButterfinger.add(20); testButterfinger.add(20); testButterfinger.add(20);
		testHersheys = new ArrayList<Integer>();
		testHersheys.add(20); testHersheys.add(20); testHersheys.add(20); testHersheys.add(20); testHersheys.add(20);
		testSkittles = new ArrayList<Integer>();
		testSkittles.add(20); testSkittles.add(20); testSkittles.add(20); testSkittles.add(20); testSkittles.add(20);
		testDoritos = new ArrayList<Integer>();
		testDoritos.add(20); testDoritos.add(20); testDoritos.add(20); testDoritos.add(20); testDoritos.add(20);
		testCheetos = new ArrayList<Integer>();
		testCheetos.add(20); testCheetos.add(20); testCheetos.add(20); testCheetos.add(20); testCheetos.add(20);
		testBabyRuth = new ArrayList<Integer>();
		testBabyRuth.add(20); testBabyRuth.add(20); testBabyRuth.add(20); testBabyRuth.add(20); testBabyRuth.add(20);
		testFritos = new ArrayList<Integer>();
		testFritos.add(20); testFritos.add(20); testFritos.add(20); testFritos.add(20); testFritos.add(20);
		testWater = new ArrayList<Integer>();
		testWater.add(1000000); testWater.add(1000000); testWater.add(1000000); testWater.add(1000000); testWater.add(1000000);
		testPepsi = new ArrayList<Integer>();
		testPepsi.add(20); testPepsi.add(20); testPepsi.add(20); testPepsi.add(20); testPepsi.add(20);
		
		milkyWay = new Item("MilkyWay", 2, 5, 1.00, testMilkyWay);
		initialItems5.add(milkyWay);
		butterfinger = new Item("Butterfinger", 3, 5, 1.00, testButterfinger);
		initialItems5.add(butterfinger);
		hersheys = new Item("Hersheys", 15, 5, 1.00, testHersheys);
		initialItems5.add(hersheys);
		skittles = new Item("Skittles", 13, 5, 1.00, testSkittles);
		initialItems5.add(skittles);
		doritos = new Item("Doritos", 20, 5, 1.50, testDoritos);
		initialItems5.add(doritos);
		cheetos = new Item("Cheetos", 25, 5, 1.50, testCheetos);
		initialItems5.add(cheetos);
		babyRuth = new Item("Baby Ruth", 14, 5, 1.00, testBabyRuth);
		initialItems5.add(babyRuth);
		fritos = new Item("Fritos", 26, 5, 1.25, testFritos);
		initialItems5.add(fritos);
		water = new Item("Water", 40, 5, 1.00, testWater);
		initialItems5.add(water);
		pepsi = new Item("Pepsi", 41, 5, 1.75, testPepsi);
		initialItems5.add(pepsi);
		
		VendingMachine machine5 = new VendingMachine(4, 1, 10, 5, 10.00, initialItems5, startTime);
		addNewMachine(machine5);
		
		///////////////////////////////////////////////////////////
		//
		// 		Vending Machine 6
		//
		// initialItems3 (10 x 1 x 5), testing rows  [expires around 20]
		//
		
		testMilkyWay = new ArrayList<Integer>();
		testMilkyWay.add(20); testMilkyWay.add(20); testMilkyWay.add(20); testMilkyWay.add(20); testMilkyWay.add(20);
		testButterfinger = new ArrayList<Integer>();
		testButterfinger.add(20); testButterfinger.add(20); testButterfinger.add(20); testButterfinger.add(20); testButterfinger.add(20);
		testHersheys = new ArrayList<Integer>();
		testHersheys.add(20); testHersheys.add(20); testHersheys.add(20); testHersheys.add(20); testHersheys.add(20);
		testSkittles = new ArrayList<Integer>();
		testSkittles.add(20); testSkittles.add(20); testSkittles.add(20); testSkittles.add(20); testSkittles.add(20);
		testDoritos = new ArrayList<Integer>();
		testDoritos.add(20); testDoritos.add(20); testDoritos.add(20); testDoritos.add(20); testDoritos.add(20);
		testCheetos = new ArrayList<Integer>();
		testCheetos.add(20); testCheetos.add(20); testCheetos.add(20); testCheetos.add(20); testCheetos.add(20);
		testBabyRuth = new ArrayList<Integer>();
		testBabyRuth.add(20); testBabyRuth.add(20); testBabyRuth.add(20); testBabyRuth.add(20); testBabyRuth.add(20);
		testFritos = new ArrayList<Integer>();
		testFritos.add(20); testFritos.add(20); testFritos.add(20); testFritos.add(20); testFritos.add(20);
		testWater = new ArrayList<Integer>();
		testWater.add(1000000); testWater.add(1000000); testWater.add(1000000); testWater.add(1000000); testWater.add(1000000);
		testPepsi = new ArrayList<Integer>();
		testPepsi.add(20); testPepsi.add(20); testPepsi.add(20); testPepsi.add(20); testPepsi.add(20);
		
		milkyWay = new Item("MilkyWay", 2, 5, 1.00, testMilkyWay);
		initialItems6.add(milkyWay);
		butterfinger = new Item("Butterfinger", 3, 5, 1.00, testButterfinger);
		initialItems6.add(butterfinger);
		hersheys = new Item("Hersheys", 15, 5, 1.00, testHersheys);
		initialItems6.add(hersheys);
		skittles = new Item("Skittles", 13, 5, 1.00, testSkittles);
		initialItems6.add(skittles);
		doritos = new Item("Doritos", 20, 5, 1.50, testDoritos);
		initialItems6.add(doritos);
		cheetos = new Item("Cheetos", 25, 5, 1.50, testCheetos);
		initialItems6.add(cheetos);
		babyRuth = new Item("Baby Ruth", 14, 5, 1.00, testBabyRuth);
		initialItems6.add(babyRuth);
		fritos = new Item("Fritos", 26, 5, 1.25, testFritos);
		initialItems6.add(fritos);
		water = new Item("Water", 40, 5, 1.00, testWater);
		initialItems6.add(water);
		pepsi = new Item("Pepsi", 41, 5, 1.75, testPepsi);
		initialItems6.add(pepsi);
		
		VendingMachine machine6 = new VendingMachine(5, 10, 1, 5, 10.00, initialItems6, startTime);
		addNewMachine(machine6);
		
	}
	
	/**
	 * Adds a vending machine object to this system
	 * @param machine machine object to be added to the list
	 */
	public void addNewMachine(VendingMachine machine){
		machines.add(machine);
	}
	
	/**
	 * Displays all the machines in the system to the command line.
	 */
	public ArrayList<VendingMachine> listCurrentMachines(){
		ArrayList<VendingMachine> onlineMachines = new ArrayList<VendingMachine>();
		for(int i = 0; i < machines.size(); i++){
			if(machines.get(i).getStatus()){
				onlineMachines.add(machines.get(i));
			}
		}
		return onlineMachines;
	}
	
	/**
	 * Displays the machines in this system
	 */
	public void printCurrentMachines(){
		ArrayList<VendingMachine> onlineMachines = listCurrentMachines();
		for(int i = 0; i < onlineMachines.size(); i++){
			System.out.println("Machine ID: " + onlineMachines.get(i).getMachineID());
		}
	}
	
	/**
	 * Initialized the list of Item ID numbers that will be used throughout this 
	 * system
	 */
	public void initalizeItemList(){
		itemsList.put("Snickers", 1);
		itemsList.put("Milky Way", 2);
		itemsList.put("Butterfinger", 3);
		itemsList.put("3 Musketeers", 4);
		itemsList.put("M&Ms", 5);
		itemsList.put("Crunch", 6);
		itemsList.put("PayDay", 7);
		itemsList.put("Kit Kat", 8);
		itemsList.put("Reeses", 9);
		itemsList.put("Twizzlers", 10);
		itemsList.put("Fiber One", 11);
		itemsList.put("Poptart", 12);
		itemsList.put("Skittles", 13);
		itemsList.put("Baby Ruth", 14);
		itemsList.put("Hersheys", 15);
		itemsList.put("Twix", 16);
		itemsList.put("Doritos", 20);
		itemsList.put("SunChips", 21);
		itemsList.put("Lays", 22);
		itemsList.put("Cheez-It", 23);
		itemsList.put("Rice Krispies", 24);
		itemsList.put("Cheetos", 25);
		itemsList.put("Fritos", 26);
		itemsList.put("Combos", 27);
		itemsList.put("SourPatch", 28);
		itemsList.put("Sweedish Fish", 29);
		itemsList.put("Beef Jerky", 30);
		itemsList.put("Water", 40);
		itemsList.put("Pepsi", 41);
		itemsList.put("Mountain Dew", 42);
		itemsList.put("Rootbeer", 43);
		itemsList.put("AMP", 44);
		itemsList.put("Sobe", 45);
		itemsList.put("RedBull", 46);
		itemsList.put("Gatorade", 47);
		itemsList.put("Orange Juice", 48);
		itemsList.put("Apple Juice", 49);
	}
	public void addNewSystemItem(String name, int ID){
		itemsList.put(name, ID);
	}
	
	
	/**
	 * Displays the raw purchase statistics from the system
	 */
	public void stats(){
		stats.printAggregates();
	}
	
	/**
	 * Returns the ags hashmap
	 */
	public HashMap<Integer,Integer> getAgs(){
		return stats.getAgs();
	}
	
	public ArrayList<String> getBar(int machineID){
		return stats.getBar(machineID);
	}
	
	/**
	 * Inserts a purchase data-point into the system
	 * @param name the name of the item bought
	 * @param itemID the item ID (defined by the system) of the item bought
	 * @param machineID the machine entry number in the system that item was bought
	 * from
	 * @param itemIndex the location on the shelf the item was when purchased
	 */
	public void addStat(String name, int itemID, int machineID, int itemIndex){
		stats.addStat(name, itemID, machineID, itemIndex);
	}
	
	/**
	 * Inserts a manager profile into the system
	 * @param user the username for this new profile
	 * @param pass the password for this new profile
	 */
	public void addManager(String user, String pass, Scanner scan){
		boolean found = false;
		for(int x = 0; x < managerList.size(); x++){
			if(user.equals(managerList.get(x).getUsername())){
				found = true;
			}
		}
		if(!found){
			boolean correctInput = false;
			while(!correctInput){
				System.out.println("You are about to creat a new manager with the credentials:\nUsername: " + 
									user+ "\nPassword: " + pass + "\nDo you wish to continue?(y/n)");
				
				String yesorno = scan.nextLine();
				if(yesorno.equals("")){
					
				}else{
					char charArray[] = yesorno.toLowerCase().toCharArray();
					if(charArray[0]=='y'){
						Manager m = new Manager(user, pass);
						managerList.add(m);
						correctInput = true;
						System.out.println("Manager: " +user +" created");
						return;
					}else if(charArray[0]=='n'){
						System.out.println("Aborting - no new manager created");
						correctInput = true;
						return;
					}else{
						System.out.println("Invalid Input");
					}
				}
			}
		}else{
			System.out.println("Than username is not available");
		}
	}
	
	// GUI
	public void addManager(String user, String pass){
		boolean found = false;
		for(int x = 0; x < managerList.size(); x++){
			if(user.equals(managerList.get(x).getUsername())){
				found = true;
			}
		}
		if(!found){
			Manager m = new Manager(user, pass);
			managerList.add(m);
		}
	}
	
	/**
	 * Adds a restocker profile into the system
	 * @param user the username for the new profile
	 * @param pass the password for the new profile
	 */
	public void addRestocker(String user, String pass, Scanner scan){
		boolean found = false;
		for(int x = 0; x < restockerList.size(); x++){
			if(user.equals(restockerList.get(x).getUsername())){
				found = true;
			}
		}
		if(!found){
			boolean correctInput = false;
			while(!correctInput){
				System.out.println("You are about to creat a new restocker with the credentials:\nUsername: " + 
									user+ "\nPassword: " + pass + "\nDo you wish to continue?(y/n)");
				String yesorno = scan.nextLine();
				if(yesorno.equals("")){
					
				}else{
					yesorno.toLowerCase();
					char arrayChar[] = yesorno.toCharArray();
					
					if(arrayChar[0]=='y'){
						Restocker r = new Restocker(user, pass);
						restockerList.add(r);
						System.out.println("Restocker: " + user + " created");
						correctInput = true;
					}else if(arrayChar[0]=='n'){
						System.out.println("Aborting - no new restocker created");
						correctInput = true;
					}else{
						System.out.println("Invalid Input");
					}
				}
				
			}
		}else{
			System.out.println("Than username is not available");
		}
	}
	
	// GUI
	public void addRestocker(String user, String pass){
		boolean found = false;
		for(int x = 0; x < restockerList.size(); x++){
			if(user.equals(restockerList.get(x).getUsername())){
				found = true;
			}
		}
		if(!found){
			Restocker r = new Restocker(user, pass);
			restockerList.add(r);	
		}
	}
	
	/**
	 * Removes a manager profile from the system (GUI)
	 * @param user the username of the profile being removed
	 */
	public void removeManager(String user){
		boolean found = false;
		for(int x = 0; x < managerList.size(); x++){
			if(user.equals(managerList.get(x).getUsername())){
				found = true;
			}
		}
		if(found){
			if(managerList.size() > 1){
				for(int x = 0; x < managerList.size(); x++){
					if(user.equals(managerList.get(x).getUsername())){
						managerList.remove(x);
					}
				}
			}
		}				
	}
	
	/**
	 * Removes a restocker profile from the system (GUI)
	 * @param user the username of the profile being removed
	 */
	public void removeRestocker(String user){
		boolean found = false;
		for(int x = 0; x < restockerList.size(); x++){
			if(user.equals(restockerList.get(x).getUsername())){
				found = true;
			}
		}
		if(found){
			for(int x = 0; x < restockerList.size(); x++){
				if(user.equals(restockerList.get(x).getUsername())){
					restockerList.remove(x);
				}
			}
		}
	}
	

	/**
	 * Fetches a list of the manager profiles in this system
	 * @return the list of managers
	 */
	//testing purposes
	public ArrayList<Manager> getManagerList(){
		return managerList;
	}
	
	/**
	 * Fetches a list of restocker profiles in this system
	 * @return the list of restockers
	 */
	//testing purposes
	public ArrayList<Restocker> getRestockerList(){
		return restockerList;
	}
	
	/**
	 * Inserts a restocker data-point into the system
	 * @param name the name of the instruction
	 * @param instruction the instruction text the restocker followed
	 */
	public void addRestockStat(String name, ArrayList<String> instruction){
		stats.addRestock(name, instruction);
	}
	
	/**
	 * Returns the restocker of that username and password or null if he does not exist
	 * @param username - Sring username of the restocker
	 * @param password - String password of the restocker
	 * @return an instance of a restocker
	 */
	public Restocker restockerExists(String user, String pass){
		for(int x = 0; x < restockerList.size(); x++){
			if(user.equals(restockerList.get(x).getUsername()) && 
					pass.equals(restockerList.get(x).getPassword()) ){
				return restockerList.get(x);
			}
		}
		return null;
	}
	
	public VendingMachine getMachine(int machineID){
		VendingMachine temp = new VendingMachine();
		for(int x = 0; x < machines.size(); x++){
			if(machines.get(x).getMachineID() == machineID){
				temp = machines.get(x);
			}
		}
		return temp;
	}
	
	
	public boolean machineExists(int machineID){
		for(int i = 0; i < machines.size(); i++){
			if(machineID == machines.get(i).getMachineID()){
				return true;
			}
		}
		return false;
	}
	
	public TreeMap<String, Integer> getItemList(){
		return itemsList;
	}
}


