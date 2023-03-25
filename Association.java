class Association<k, v> {
    private String key;
    private String value1, value2;

    public Association(String key, String value1, String value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getKey() {
        return key;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }
}