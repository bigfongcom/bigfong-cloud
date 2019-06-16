import com.bigfong.cloud.scheduserver.ScheduServerApplication;
import com.bigfong.cloud.scheduserver.task.async.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ScheduServerApplication.class})// 指定启动类
public class MyTests {

    private Task task;

    @Before
    public void testBefore(){
        task = new Task();
    }

    /**
     * 使用断言
     */
    @Test
    public void test2() throws Exception{
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }

}