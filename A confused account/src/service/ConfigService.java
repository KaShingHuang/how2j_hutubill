package service;
import dao.ConfigDAO;
import entity.Config;

public class ConfigService {
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";

    static ConfigDAO dao= new ConfigDAO();
    static{
        init();
    }

    public static void init(){
        init(budget, default_budget);
        init(mysqlPath, "");
    }

    //初始化数据里面budget和mysql路径的数据
    private static void init(String key, String value) {

        Config config= dao.getByKey(key);
        if(config==null){
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            dao.add(c);
        }
    }

    //得到想要的关键字的值
    public String get(String key) {
        Config config= dao.getByKey(key);
        return config.getValue();
    }

    //更新对应关键字的值
    public void update(String key, String value){
        Config config= dao.getByKey(key);
        config.setValue(value);
        dao.update(config);
    }

    //得到对应的预算
    public int getIntBudget() {
        return Integer.parseInt(get(budget));
    }

}
