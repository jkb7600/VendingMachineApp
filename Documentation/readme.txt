~ French Toast Vending, inc. ~
readme.txt


To run: java -jar FrenchToastMafia.jar



##########################
#  Password Information  #
##########################
User: dxkvse,     Pass: password   ~ (Manager / Restocker)
User: ajl2612     Pass: password   ~ (Manager / Restocker)
User: restocker1  Pass: password   ~ (Restocker)
User: manager1    Pass: password   ~ (Manager)


// Start location
###########
 Main Menu
###########
Who is the current user?
0 - Exit	<closes the program>
1 - Customer	<opens the Customer UI>
2 - Restocker	<opens the Restocker UI>
3 - Manager	<opens the Manager UI>



##########
 Customer
##########
**Note**
- Before customer runs, you are asked to input the current Machine you are at.

		[[ example item output ]]

5 $1.00	Crunch quantity: 3   ~~ (Slot, Price, Name, Quantity) ~~

Customer Balance: $0.00

0. Quit			<returns to main menu>
1. Insert Money		<prompts for amount to insert>
2. Make Selection	<prompts for selected item ID,
			 dispenses item, and refunds remaining>
3. Refund Change	<returns any inserted money>



###########
 Restocker
###########
**Note**
- Username/Password required; found at top of readme.
- Machine location is prompted.
- Machine becomes "offline" when in use by Restocker


0. Logout		<returns to main menu, logs out>
1. ViewReport		<views the current report>
2. Start Restocking	<transitions to restocking prompts>
3. Add Notes		<enables restocker to add notes>



#########
 Manager
#########
**Note**
- Username/Password required; found at top of readme.


0. Logout			<returns to main menu, logs out>
1. Add Machine			<adds a new vending machine>
2. Delete Machine		<removes an existing vending machine>
3. Upload Restocker Report	<used to upload a Report .cvs file;
				 machine ID is prompted>
4. View Machine State		<used to view inventory, expired, and notes;
				 machine ID is prompted>
5. Add New Manager		<adds a new manager>
6. Delete Manager		<removes an existing manager>
7. Add New Restocker		<adds a new restocker>
8. Delete Restocker		<removes an existing restocker>
9. Statistics			<used to view statistics>


###########
More Info
###########
The restocker report .csv file uploaded by the manager must be in a very 
specific format in order to run corrtly. The format is as follows:

stringInstruction commandID machineID itemID commandArgs


changeCost 		0 machineID itemID newCost
removeQuantity 	1 machineID itemID quantityToRemove
addQuantity 	2 machineID itemID quantityToAdd expDate1 expdate2... expDate"n"
discontinueItem 3 machineID itemID
removeMoney 	4 machineID amountToRemove
AddItem 		5 machineID itemName itemID itemCost itemNum expDate1 expdate2... expDate"n"

Where each data point must be on its own line of a .csv file, seperated by a comma, with no
extraneous comma's.

An Example of a line instructing the restocker to change the cost of item 1, in machine 0:
Change cost of item1 to $X.XX,0,1,X.XX

############
   Errors
############
There are a few errors we know exist.

The entire machine operates under the assumption that the restocker orders the items,
from soonest expiration first to latest expiration date last. However, we do not check
to make sure that a Manager entering a new Item enters the expiration dates of said
item in the correct order. This should not cause an actual compile error, but will
lead to unpredictable results when you call isExpired() on an item.

The RestockerReport.csv file assumes perfect format. This means that if you have a
mistake in the restocker report then you will most likely receive an actual run
time error. We also assume that the manager is providing "perfect instructions"
meaning he is not adding new items to a full machine without first discontinuing
an item. Many of these errors will be caught by bounds checking, but we have not
tested the system to any significant extent.
