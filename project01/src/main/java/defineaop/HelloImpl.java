package defineaop;


/**
 * Created by wangxin on 2018/4/26.
 */
public class HelloImpl implements Hello {
    public void add(){
        System.out.println("执行add----------");
    }
    public int delete(){
        System.out.println("执行delete----------");
        return 1;
    }
}
