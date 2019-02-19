import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SickTravelers {
	private static final int MAX_STEPS = 365;
	static List<String> result = new ArrayList<>();
    private static ArrayList<Traveler> travelers = new ArrayList<>();

    public enum CityStatus { 
        INFECTED, NOT_INFECTED
    }

    private static HashMap<String, CityStatus> cities_infected = new HashMap<>();

    private enum Health {

        HEALTHY("HEALTHY"),
        RECOVERING("RECOVERING"),
        SICK("SICK"),
        INFECTED(""); 

        final String message;
        Health(String h) {
            this.message = h;
        }
    }


    static class Traveler {
        private int currentCity = 0;
        private int numb_cities;
        private String[] city_names;
        private String name;
        private Health health;

        public String getName() {
            return name;
        }

        public String currCity() {
            return city_names[currentCity];
        }

        public boolean isInfectious() {
            return health == Health.SICK || health == Health.RECOVERING;
        }

        public Traveler(String name, Health h, String[] cities) {
            this.name = name;
            this.city_names = cities;
            this.numb_cities = cities.length;
            this.health = h;
        }
        
        public boolean isHealthy() {
            return health == Health.HEALTHY;
        }

        public void checkIfInfected() {
            if (health == Health.HEALTHY) {
                boolean got_infected = cities_infected.get(city_names[currentCity]) == CityStatus.INFECTED;
                health = (got_infected) ? Health.INFECTED : Health.HEALTHY;
            }
        }

        public void moveNext() {
        	updateHealth();
            currentCity = (currentCity + 1) % numb_cities;
            if (this.isInfectious()) {     
                cities_infected.put(city_names[currentCity], CityStatus.INFECTED); 
            }
        }

        public void updateHealth() {
            switch (health) {
                case HEALTHY:
                    break;
                case RECOVERING:
                    health = Health.HEALTHY;
                    break;
                case SICK:
                    health = Health.RECOVERING;
                    break;
                case INFECTED:                 
                    health = Health.SICK;      
                    break;                      
            }
        }
    }

    private static boolean allAreHealthy() { 
    	for (Traveler traveler : travelers) {
            if (!traveler.isHealthy()) {
                return false;
            }
        }
        return true;
    }
    
    private static void printTravelers() {
    	StringBuilder sb = new StringBuilder();
    	for(Traveler t : travelers) {
    		sb.append(t.health + " ");
    	}
    	sb.deleteCharAt(sb.length() - 1);	
    	result.add(sb.toString());
    }

    private static void setupValues(String[] input_strings) {
        for (String str : input_strings) {
            String[] fields = str.split(" ");
            String[] cities = new String[fields.length - 2];
            System.arraycopy(fields, 2, cities, 0, cities.length);
            Traveler traveler = new Traveler(fields[0], Health.valueOf(fields[1]), cities);

            if (traveler.isInfectious())
                cities_infected.put(traveler.currCity(), CityStatus.INFECTED);

            for (String city : cities)
                cities_infected.putIfAbsent(city, CityStatus.NOT_INFECTED);                                         
            travelers.add(traveler);
        }
    }

    static String[] traceDisease(String[] initialStates) {
        setupValues(initialStates);
        Set<String> all_cities = cities_infected.keySet();
        int step = 0;   
        StringBuilder sb = new StringBuilder();
        for(Traveler t : travelers)
        	sb.append(t.getName() + " ");
        sb.deleteCharAt(sb.length() - 1);
        result.add(sb.toString());
        
        while (step < MAX_STEPS) { 
            printTravelers();
            travelers.forEach(Traveler::checkIfInfected);
            if (allAreHealthy()) { break; }
            all_cities.forEach(city -> cities_infected.put(city, CityStatus.NOT_INFECTED));
            travelers.forEach(Traveler::moveNext);                  
            step++;
        }
        
        String ans[] = new String[result.size() + 1];
        for(int i = 0; i < result.size(); i++)
        	ans[i] = result.get(i);
        
        ans[result.size()] = String.valueOf(result.size() - 1);
        return ans;
    }
    
  
    public static void main(String[] args) {
        
        String[] travelers = new String[]{   // 5 steps
                "Jasmine SICK DC DC DC DC DC DC",
                "Nick HEALTHY DC NY NY NY NY PA",
                "Yun HEALTHY PA DC PA PA PA PA"
        };
        String a[] = traceDisease(travelers);
        for(String s : a)
        	System.out.println(s);
    }
}