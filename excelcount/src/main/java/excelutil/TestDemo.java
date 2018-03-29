package excelutil;

@TableName("Head")
@AutoWidth
public class TestDemo {
    private String name;
    private String age;
    private String jet;

    @ColumnName(value = "name", order = 5)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ColumnName(value = "age", order = 10)
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @ColumnName(value = "jet", order = 7)
    public String getJet() {
        return jet;
    }

    public void setJet(String jet) {
        this.jet = jet;
    }
}
