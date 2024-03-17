public class Group {
    private String name;
    private Athlete[] athletes;
    private int count;

    public Group(String name, int size) {
        this.name = name;
        this.athletes = new Athlete[size];
        this.count = 0;
    }

    public boolean addAthlete(String name, int maxGrades) {
        if (count < athletes.length) {
            athletes[count] = new Athlete(name, maxGrades);
            count++;
            return true;
        }
        return false;
    }

    public boolean deleteAthlete(String name) {
        for (int i = 0; i < count; i++) {
            if (athletes[i].equals(name)) {
                athletes[i] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    public String getBestAthleteName() {
        if (count == 0) {
            return null;
        }
        double maxAverage = athletes[0].average();
        String bestAthleteName = athletes[0].getName();
        for (int i = 1; i < count; i++) {
            double currentAverage = athletes[i].average();
            if (currentAverage > maxAverage) {
                maxAverage = currentAverage;
                bestAthleteName = athletes[i].getName();
            }
        }
        return bestAthleteName;
    }

    public boolean addGrade(String athleteName, String apparatus, double score) {
        for (int i = 0; i < count; i++) {
            if (athletes[i].getName().equals(athleteName)) {
                return athletes[i].addGrade(apparatus, score);
            }
        }
        return false;
    }
}
