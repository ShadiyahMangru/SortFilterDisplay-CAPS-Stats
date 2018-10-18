import java.util.*;
import java.io.*;

class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	
	//constructors
	public HockeyPlayer(String lastName, String position){
		this.lastName = lastName;
		this.position = position;
	}
	
	public HockeyPlayer(HockeyPlayer hp){
		this(hp.lastName, hp.position);
	}
	
	//setters
	public void setLastName(String lastName){
		this.lastName = lastName;	
	}
	
	public void setPosition(String position){
		this.position = position;	
	}
	
	//getters
	public String getLastName(){
		return lastName;	
	}
	
	public String getPosition(){
		return position;	
	}
	
	//print
	public String printPositionDetails(){
		return "\nName: " + lastName + "\tPosition: " + position;
	}
}


class Goalies extends HockeyPlayer implements Comparable<Goalies>{
	//fields
	private int shotsAgainst;
	private int goalsAgainst;
	private int saves;
	private ArrayList<Goalies> goaliesRoster;
	private static int sortGoaliesBy;
	
	//constructors
	public Goalies(){
		super(" ", " ");
		setGoaliesRoster();	
	}
	
	public Goalies(int sortGoaliesBy){
		super(" ", " ");
		setGoaliesRoster();
		this.sortGoaliesBy = sortGoaliesBy;
	}
	
	public Goalies(String lastName, String position, int shotsAgainst, int goalsAgainst, int saves){
		super(lastName, position);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
	}
	
	public Goalies(HockeyPlayer hp, int shotsAgainst, int goalsAgainst, int saves){
		super(hp);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
	}
	
	/**
	* a method that defines how to sort Goalies numerically by a stat
	* @param Player the player to which we are comparing
	*/
	@Override
    	public int compareTo(Goalies other) {
    	switch(sortGoaliesBy){
    	case 1:
    		if (this.getShotsAgainst() < other.getShotsAgainst()) {
    			return -1;
    		}
    		if (this.getShotsAgainst() == other.getShotsAgainst()) { 
    			return 0;
    		}
    		break;
   	case 2:
    		if (this.getGoalsAgainst() < other.getGoalsAgainst()) {
    			return -1;
    		}
    		if (this.getGoalsAgainst() == other.getGoalsAgainst()) { 
    			return 0;
    		}
    		break;
    	case 3:
    		if (this.getSaves() < other.getSaves()) {
    			return -1;
    		}
    		if (this.getSaves() == other.getSaves()) { 
    			return 0;
    		}
    		break;
    	}
    	return 1;
    	}
	
	//setters
	public void setShotsAgainst(int shotsAgainst){
		this.shotsAgainst = shotsAgainst;	
	}
	
	public void setGoalsAgainst(int goalsAgainst){
		this.goalsAgainst = goalsAgainst;	
	}
	
	public void setSaves(int saves){
		this.saves = saves;	
	}
	
	public void setGoaliesRoster(){
		goaliesRoster = new ArrayList<Goalies>();
		goaliesRoster.add(new Goalies("Holtby", "Goalie", 1648, 153, 1495));
		goaliesRoster.add(new Goalies("Grubauer", "Goalie", 953, 73, 880));
	}
	
	//getters
	public int getShotsAgainst(){
		return shotsAgainst;	
	}
	
	public int getGoalsAgainst(){
		return goalsAgainst;	
	}
	
	public int getSaves(){
		return saves;	
	}
	
	public ArrayList<Goalies> getGoaliesRoster(){
		return goaliesRoster;
	}
	
	//print
	@Override
	public String printPositionDetails(){
		return super.printPositionDetails() + "\tShots Against: " + shotsAgainst + "\tGoals Against: " + goalsAgainst + "\tSaves: " + saves;
	}
}


class Skaters extends HockeyPlayer implements Comparable<Skaters>{
	//fields
	private int goals;
	private int assists;
	private int points;
	private int plusMinus;
	private ArrayList<Skaters> skatersRoster;
	private static int sortSkatersBy;
	
	//constructors
	public Skaters(){
		super(" ", " ");
		setSkatersRoster();	
	}
	
	public Skaters(int sortSkatersBy){
		super(" ", " ");
		setSkatersRoster();
		this.sortSkatersBy = sortSkatersBy;
	}
	
	public Skaters(String lastName, String position, int goals, int assists, int points, int plusMinus){
		super(lastName, position);
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.plusMinus = plusMinus;
	}
	
	public Skaters(HockeyPlayer hp, int goals, int assists, int points, int plusMinus){
		super(hp);
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.plusMinus = plusMinus;
	}
	
	/**
	* a method that defines how to sort Skaters numerically by a stat
	* @param Player the player to which we are comparing
	*/
	@Override
    	public int compareTo(Skaters other) {
    	switch(sortSkatersBy){
    	case 1:
    		if (this.getPoints() < other.getPoints()) {
    			return -1;
    		}
    		if (this.getPoints() == other.getPoints()) { 
    			return 0;
    		}
    		break;
   	case 2:
    		if (this.getGoals() < other.getGoals()) {
    			return -1;
    		}
    		if (this.getGoals() == other.getGoals()) { 
    			return 0;
    		}
    		break;
    	case 3:
    		if (this.getAssists() < other.getAssists()) {
    			return -1;
    		}
    		if (this.getAssists() == other.getAssists()) { 
    			return 0;
    		}
    		break;
    	case 4:
    		if (this.getPlusMinus() < other.getPlusMinus()) {
    			return -1;
    		}
    		if (this.getPlusMinus() == other.getPlusMinus()) { 
    			return 0;
    		}
    		break;
    	}
    	return 1;
    	}
		
	//setters
	public void setGoals(int goals){
		this.goals = goals;
	}
	
	public void setAssists(int assists){
		this.assists = assists;	
	}
	
	public void setPoints(int points){
		this.points = points;	
	}
	
	public void setPoints(int goals, int assists){
		points = goals + assists;	
	}
	
	public void setPoints(){
		points = goals + assists;	
	}
	
	public void setPlusMinus(int plusMinus){
		this.plusMinus = plusMinus;	
	}
	
	public void setSkatersRoster(){
		skatersRoster = new ArrayList<Skaters>();
		skatersRoster.add(new Skaters("Ovechkin", "Forward, LW", 49, 38, 87, 3));
		skatersRoster.add(new Skaters("Kuznetsov", "Forward, C", 27, 56, 83, 3));
		skatersRoster.add(new Skaters("Backstrom", "Forward, C", 21, 50, 71, 5));
		skatersRoster.add(new Skaters("Carlson", "Defense", 15, 53, 68, 0));
		skatersRoster.add(new Skaters("Oshie", "Forward, RW", 18, 29, 47, 2));
		skatersRoster.add(new Skaters("Eller", "Forward, C", 18, 20, 38, -6));
		skatersRoster.add(new Skaters("Wilson", "Forward, RW", 14, 21, 35, 10));
		skatersRoster.add(new Skaters("Connolly", "Forward, RW", 15, 12, 27, -6));
		skatersRoster.add(new Skaters("Vrana", "Forward, LW", 13, 14, 27, 2));
		skatersRoster.add(new Skaters("Peluso", "Forward, RW", 0, 0, 0, 0));
		skatersRoster.add(new Skaters("O'Brien", "Forward, C", 0, 0, 0, 0));
		skatersRoster.add(new Skaters("Gersich", "Forward, LW", 0, 1, 1, -1));
		skatersRoster.add(new Skaters("Graovac", "Forward, C", 0, 0, 0, -3));
		skatersRoster.add(new Skaters("Boyd", "Forward, C", 0, 1, 1, 2));
		skatersRoster.add(new Skaters("Walker", "Forward, LW", 1, 0, 1, 1));
		skatersRoster.add(new Skaters("Smith-Pelly", "Forward, RW", 7, 9, 16, -6));
		skatersRoster.add(new Skaters("Burakovsky", "Forward, LW", 12, 13, 25, 3));
		skatersRoster.add(new Skaters("Stephenson", "Forward, C", 6, 12, 18, 13));
		skatersRoster.add(new Skaters("Beagle", "Forward, C", 7, 15, 22, 3));
		skatersRoster.add(new Skaters("Chiasson", "Forward, RW", 9, 9, 18, 1));
		skatersRoster.add(new Skaters("Orlov", "Defense", 10, 21, 31, 10));
		skatersRoster.add(new Skaters("Niskanen", "Defense", 7, 22, 29, 24));
		skatersRoster.add(new Skaters("Djoos", "Defense", 3, 11, 14, 13));
		skatersRoster.add(new Skaters("Bowey", "Defense", 0, 12, 12, -3));
		skatersRoster.add(new Skaters("Orpik", "Defense", 0, 10, 10, -9));
		skatersRoster.add(new Skaters("Chorney", "Defense", 1, 3, 4, 8));
		skatersRoster.add(new Skaters("Jerabek", "Defense", 1, 3, 4, -1));
		skatersRoster.add(new Skaters("Kempny", "Defense", 2, 1, 3, 1));
		skatersRoster.add(new Skaters("Ness", "Defense", 0, 1, 1, 2));
	}
	
	//getters
	public int getGoals(){
		return goals;	
	}
	
	public int getAssists(){
		return assists;
	}	
	
	public int getPoints(){
		return points;	
	}
	
	public int getPlusMinus(){
		return plusMinus;	
	}
	
	public ArrayList<Skaters> getSkatersRoster(){
		return skatersRoster;	
	}
	
	//print
	@Override
	public String printPositionDetails(){
		return super.printPositionDetails() + "\tGoals: " + goals + "\tAssists: " + assists + "\tPoints: " + points + "\t+/-: " + plusMinus;
	}
}


class SortStatsGoalies extends Goalies{
	//fields
	private ArrayList<Goalies> goaliesSorted;
	
	//constructors
	SortStatsGoalies(){
	}
	
	SortStatsGoalies(int g){
		Goalies gl = new Goalies(g);
		setGoaliesSorted();
	}
	
	//setters
	public void setGoaliesSorted(){
		goaliesSorted = new ArrayList<Goalies>(getGoaliesRoster());
		Collections.sort(goaliesSorted);
	}
	
	//getters
	public ArrayList<Goalies> getGoaliesSorted(){
		return goaliesSorted;	
	}
}

class FilterStatsGoalies extends Goalies{
	//fields
	private int filterBy;
	private int minInclusive;
	private int maxInclusive;
	private ArrayList<Goalies> goaliesFiltered;
	
	//constructors
	FilterStatsGoalies(){
	}
	
	FilterStatsGoalies(int filterBy, int minInclusive, int maxInclusive){
		this.filterBy = filterBy;
		this.minInclusive = minInclusive;
		this.maxInclusive = maxInclusive;
	}
	
	//setters
	public void setFilterBy(int filterBy){
		this.filterBy = filterBy;	
	}
	
	public void setMinInclusive(int minInclusive){
		this.minInclusive = minInclusive;	
	}
	
	public void setMinInclusive(){
	try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter minimum inclusive value: ");
			minInclusive = Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			setMinInclusive();
		}	
	}
	
	public void setMaxInclusive(int maxInclusive){
		this.maxInclusive = maxInclusive;	
	}
	
	public void setMaxInclusive(){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter maximum inclusive value: ");
			maxInclusive = Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			setMaxInclusive();
		}	
	}
	
	public void setGoaliesFiltered(){
		goaliesFiltered = new ArrayList<Goalies>();
		switch(filterBy){
		case 1: SortStatsGoalies sa = new SortStatsGoalies(1);
			for(Goalies gl : sa.getGoaliesSorted()){
				if(gl.getShotsAgainst() >= minInclusive){
					if(gl.getShotsAgainst() <= maxInclusive){
						goaliesFiltered.add(gl);
					}
				}
			}
			break;
		case 2: SortStatsGoalies ga = new SortStatsGoalies(2);
			for(Goalies gl : ga.getGoaliesSorted()){
				if(gl.getGoalsAgainst() >= minInclusive){
					if(gl.getGoalsAgainst() <= maxInclusive){
						goaliesFiltered.add(gl);
					}
				}
			}
			break;
		case 3: SortStatsGoalies sv = new SortStatsGoalies(3);
			for(Goalies gl : sv.getGoaliesSorted()){
				if(gl.getSaves() >= minInclusive){
					if(gl.getSaves() <= maxInclusive){
						goaliesFiltered.add(gl);
					}
				}
			}
			break;
		}
	}
	
	//getters
	public int getFilterBy(){
		return filterBy;	
	}
	
	public int getMinInclusive(){
		return minInclusive;	
	}
	
	public int getMaxInclusive(){
		return maxInclusive;	
	}
	
	public ArrayList<Goalies> getGoaliesFiltered(){
		return goaliesFiltered;	
	}
}

class SortStatsSkaters extends Skaters{
	//fields
	private ArrayList<Skaters> skatersSorted;
	
	//constructors
	SortStatsSkaters(){
	}
	
	SortStatsSkaters(int s){
		Skaters sk = new Skaters(s);
		setSkatersSorted();
	}
	
	//setters
	public void setSkatersSorted(){
		skatersSorted = new ArrayList<Skaters>(getSkatersRoster());
		Collections.sort(skatersSorted);
	}
	
	//getters
	public ArrayList<Skaters> getSkatersSorted(){
		return skatersSorted;	
	}
}

class FilterStatsSkaters extends Skaters{
	//fields
	private int filterBy;
	private int minInclusive;
	private int maxInclusive;
	private ArrayList<Skaters> skatersFiltered;
	
	//constructors
	FilterStatsSkaters(){
	}
	
	FilterStatsSkaters(int filterBy, int minInclusive, int maxInclusive){
		this.filterBy = filterBy;
		this.minInclusive = minInclusive;
		this.maxInclusive = maxInclusive;
	}
	
	//setters
	public void setFilterBy(int filterBy){
		this.filterBy = filterBy;	
	}
	
	public void setMinInclusive(int minInclusive){
		this.minInclusive = minInclusive;	
	}
	
	public void setMinInclusive(){
	try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter minimum inclusive value: ");
			minInclusive = Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			setMinInclusive();
		}	
	}
	
	public void setMaxInclusive(int maxInclusive){
		this.maxInclusive = maxInclusive;	
	}
	
	public void setMaxInclusive(){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter maximum inclusive value: ");
			maxInclusive = Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			setMaxInclusive();
		}	
	}
	
	public void setSkatersFiltered(){
		skatersFiltered = new ArrayList<Skaters>();
		switch(filterBy){
		case 1: SortStatsSkaters p = new SortStatsSkaters(1);
			for(Skaters s : p.getSkatersSorted()){
				if(s.getPoints() >= minInclusive){
					if(s.getPoints() <= maxInclusive){
						skatersFiltered.add(s);
					}
				}
			}
			break;
		case 2: SortStatsSkaters g = new SortStatsSkaters(2);
			for(Skaters s : g.getSkatersSorted()){
				if(s.getGoals() >= minInclusive){
					if(s.getGoals() <= maxInclusive){
						skatersFiltered.add(s);
					}
				}
			}
			break;
		case 3: SortStatsSkaters a = new SortStatsSkaters(3);
			for(Skaters s : a.getSkatersSorted()){
				if(s.getAssists() >= minInclusive){
					if(s.getAssists() <= maxInclusive){
						skatersFiltered.add(s);
					}
				}
			}
			break;
		case 4: SortStatsSkaters pm = new SortStatsSkaters(4);
			for(Skaters s : pm.getSkatersSorted()){
				if(s.getPlusMinus() >= minInclusive){
					if(s.getPlusMinus() <= maxInclusive){
						skatersFiltered.add(s);
					}
				}
			}
			break;
		}
		
	}
	
	//getters
	public int getFilterBy(){
		return filterBy;	
	}
	
	public int getMinInclusive(){
		return minInclusive;	
	}
	
	public int getMaxInclusive(){
		return maxInclusive;	
	}
	
	public ArrayList<Skaters> getSkatersFiltered(){
		return skatersFiltered;	
	}
}


abstract class Output{
	//constructor
	public Output(){	
	}
	
	//outputs all players and some of their stats in a predetermined order
	public static void printRosterDetails(){
		Skaters skaters = new Skaters();
		for(Skaters s : skaters.getSkatersRoster()){
			System.out.println("Name: " + s.getLastName() + "\tPosition: " + s.getPosition() + "\tGoals: " + s.getGoals() + "\tAssists: " + s.getAssists() + "\tPoints: " + s.getPoints() + "\t+/-: " + s.getPlusMinus());	
		}
		Goalies goalies = new Goalies();
		System.out.println();
		for(Goalies g : goalies.getGoaliesRoster()){
			System.out.println("Name: " + g.getLastName() + "\tPosition: " + g.getPosition() + "\tShots Against: " + g.getShotsAgainst() + "\tGoals Against: " + g.getGoalsAgainst() + "\tSaves: " + g.getSaves());	
		}
	}
	
	//prints an arrayList of skaterStats
	public static void printSkaters(ArrayList<Skaters> sRoster){
		System.out.println("  POINTS:\t+/-:\tGOALS:\tASSISTS\tPLAYERS:  ");
		for(int i=(sRoster.size() - 1); i>=0; i--){
			System.out.println("  " + sRoster.get(i).getPoints() + "\t\t" + sRoster.get(i).getPlusMinus() + "\t" + sRoster.get(i).getGoals() + "\t" + sRoster.get(i).getAssists() + "\t" + sRoster.get(i).getLastName());	
		}		
	}
	
	//prints an arrayList of goalieStats
	public static void printGoalies(ArrayList<Goalies> gRoster){
		System.out.println("  SHOTS AGAINST:\tGOALS AGAINST:\tSAVES:\t\tPLAYERS:  ");
		for(int i=(gRoster.size() - 1); i>=0; i--){
			System.out.println("  " + gRoster.get(i).getShotsAgainst() + "\t\t\t" + gRoster.get(i).getGoalsAgainst() + "\t\t" + gRoster.get(i).getSaves() + "\t\t" + gRoster.get(i).getLastName());	
		}		
	}
	
	//gives user option of sorting or filtering stats
	public static int statsWizard(){
		System.out.println();
		System.out.println("**********************************************************************************");
		System.out.println("WELCOME TO 2017-2018 WASHINGTON CAPITALS' (SOME) REGULAR SEASON STATS WIZARD!");
		System.out.println("\nSelect an option:\n1.) Sort Stats \n2.) Filter Stats\n\n\n3.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			System.out.println();
				switch(userChoice){
					case 1: System.out.println("  You selected: SORT");
						return 1;
					case 2: System.out.println("  You selected: FILTER");
						return 2;
					case 3: System.out.print("  You selected: EXIT");
						System.exit(0);
						break;
					default: Output.statsWizard(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		statsWizard();
		}
		return 1;
	}
}


class SortOutput extends Output{
	//constructor
	private SortOutput(){
	}
	
	/**
	* a method that outputs a menu to select type of sorted stats to display on screen
	*/
	public static void userSortOptions(){
		System.out.println();
		System.out.println("**********************************************************************************");
		System.out.println("\nSelect a sort by option:\n1.) Points \n2.) Goals\n3.) Assists \n4.) +/- \n5.) Shots Against \n6.) Goals Against \n7.) Saves\n\n8.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			System.out.println();
				switch(userChoice){
					case 1: System.out.println("  You selected: Sort Washington Capitals' Stats by POINTS");
						SortStatsSkaters p = new SortStatsSkaters(1);
						Output.printSkaters(p.getSkatersSorted() );
						userSortOptions();
						break;
					case 2: System.out.println("  You selected: Sort Washington Capitals' Stats by GOALS");
						SortStatsSkaters g = new SortStatsSkaters(2);
						Output.printSkaters(g.getSkatersSorted() );
						userSortOptions();
						break;
					case 3: System.out.println("  You selected: Sort Washington Capitals' Stats by ASSISTS");
						SortStatsSkaters a = new SortStatsSkaters(3);
						Output.printSkaters(a.getSkatersSorted() );
						userSortOptions();
						break;
					case 4: System.out.println("  You selected: Sort Washington Capitals' Stats by +/-");
						SortStatsSkaters pm = new SortStatsSkaters(4);
						Output.printSkaters(pm.getSkatersSorted() );
						userSortOptions();
						break;
					case 5: System.out.println("  You selected: Sort Washington Capitals' Stats by SHOTS AGAINST");
						SortStatsGoalies sa = new SortStatsGoalies(1);
						Output.printGoalies(sa.getGoaliesSorted() );
						userSortOptions();
						break;
					case 6: System.out.println("  You selected: Sort Washington Capitals' Stats by GOALS AGAINST");
						SortStatsGoalies ga = new SortStatsGoalies(2);
						Output.printGoalies(ga.getGoaliesSorted() );
						userSortOptions();
						break;
					case 7: System.out.println("  You selected: Sort Washington Capitals' Stats by SAVES");
						SortStatsGoalies s = new SortStatsGoalies(3);
						Output.printGoalies(s.getGoaliesSorted() );
						userSortOptions();
						break;
					case 8: System.out.print("  You selected: EXIT");
						System.exit(0);
						break;
					default: userSortOptions(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		userSortOptions();
		}
	}
}

class FilterOutput extends Output{
	//constructor
	private FilterOutput(){
	}
	

	public static void userDefinedSkaterFilter(int filterByThis){
		FilterStatsSkaters fss = new FilterStatsSkaters();
		fss.setFilterBy(filterByThis);
		fss.setMinInclusive();
		fss.setMaxInclusive();
		fss.setSkatersFiltered();
		System.out.println();
		Output.printSkaters(fss.getSkatersFiltered() );	
	}
	
	
	public static void userDefinedGoalieFilter(int filterByThis){
		FilterStatsGoalies fsg = new FilterStatsGoalies();
		fsg.setFilterBy(filterByThis);
		fsg.setMinInclusive();
		fsg.setMaxInclusive();
		fsg.setGoaliesFiltered();
		System.out.println();
		Output.printGoalies(fsg.getGoaliesFiltered() );
	}
	
	/**
	* a method that outputs a menu to select which filtered stats to display on screen
	*/
	public static void userFilterOptions(){
		System.out.println();
		System.out.println("**********************************************************************************");
		System.out.println("\nSelect a stat to filter:\n1.) Points \n2.) Goals\n3.) Assists \n4.) +/- \n5.) Shots Against \n6.) Goals Against \n7.) Saves\n\n8.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			System.out.println();
				switch(userChoice){
					case 1: System.out.println("  You selected: Filter Skater POINTS");
						userDefinedSkaterFilter(1);
						userFilterOptions();
						break;
					case 2: System.out.println("  You selected: Filter Skater GOALS");
						FilterStatsSkaters g = new FilterStatsSkaters();
						userDefinedSkaterFilter(2);
						userFilterOptions();
						break;
					case 3: System.out.println("  You selected: Filter Skater ASSISTS");
						userDefinedSkaterFilter(3);
						userFilterOptions();
						break;
					case 4: System.out.println("  You selected: Filter Skater +/-");
						userDefinedSkaterFilter(4);
						userFilterOptions();
						break;
					case 5: System.out.println("  You selected: Filter Goalie SHOTS AGAINST");
						userDefinedGoalieFilter(1);
						userFilterOptions();
						break;
					case 6: System.out.println("  You selected: Filter Goalie GOALS AGAINST");
						userDefinedGoalieFilter(2);
						userFilterOptions();
						break;
					case 7: System.out.println("  You selected: Filter Goalie SAVES");
						userDefinedGoalieFilter(3);
						userFilterOptions();
						break;
					case 8: System.out.print("  You selected: EXIT");
						System.exit(0);
						break;
					default: userFilterOptions(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		userFilterOptions();
		}
	}
}


public class HockeyStatsMainV2{
	//constructor
	public HockeyStatsMainV2(){	
	}
	
	//main method
	public static void main(String... args){
		System.out.println("************************************************");
		System.out.println("SOME 2017-2018 REGULAR SEASON STATS:\n");
		RosterOutput.printRosterDetails();
		
		
		int sortFilter = Output.statsWizard();
		if(sortFilter == 1){
			SortOutput.userSortOptions();
		}
		else{
			FilterOutput.userFilterOptions();	
		}
	}
}