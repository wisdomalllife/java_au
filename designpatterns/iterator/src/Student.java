public class Student {
    private final String secondName;
    private final int group;
    private final int subgroup;

    public Student(String secondName, int group, int subgroup) {
        this.secondName = secondName;
        this.group = group;
        this.subgroup = subgroup;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getGroup() {
        return group;
    }

    public int getSubgroup() {
        return subgroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "secondName='" + secondName + '\'' +
                ", group=" + group +
                ", subgroup=" + subgroup +
                '}';
    }
}
