package initclasses;

public class MaxSalaryWorkersCount {

    private String name;
    private int salary;

    public MaxSalaryWorkersCount(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorkersCount{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
