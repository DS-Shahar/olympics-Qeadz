public class Athlete {
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
    private Grade[] grades;
    private int count;

    public Athlete(String name, int maxGrades) {
        this.name = name;
        this.grades = new Grade[maxGrades];
        this.count = 0;
    }

    public Athlete(Athlete other) {
        this.name = other.name;
        this.count = other.count;
        this.grades = new Grade[other.grades.length];
        for (int i = 0; i < other.grades.length; i++) {
            if (other.grades[i] != null) {
                this.grades[i] = new Grade(other.grades[i].getApparatus(), other.grades[i].getScore());
            }
        }
    }

    public boolean addGrade(String apparatus, double score) {
        if (count < grades.length) {
            grades[count] = new Grade(apparatus, score);
            count++;
            return true;
        }
        return false;
    }

    public boolean deleteGrade(String apparatus) {
        for (int i = 0; i < count; i++) {
            if (grades[i].getApparatus().equals(apparatus)) {
                grades[i] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    public double average() {
        if (count == 0) {
            return 1; // No grades available
        }
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += grades[i].getScore();
        }
        return sum / count;
    }

    public boolean allGradesAbove(double threshold) {
        for (int i = 0; i < count; i++) {
            if (grades[i].getScore() <= threshold) {
                return false;
            }
        }
        return true;
    }

    public boolean isBetter(Athlete other) {
        if (other == null) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (grades[i] == null && other.grades[i] != null) {
                return false;
            } else if (grades[i] != null && other.grades[i] == null) {
                return true;
            } else if (grades[i] != null && other.grades[i] != null) {
                if (grades[i].getScore() <= other.grades[i].getScore()) {
                    return false;
                }
            }
        }
        return true;
    }
}
