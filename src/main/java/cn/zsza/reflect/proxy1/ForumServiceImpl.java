package cn.zsza.reflect.proxy1;

/**
 * Created by zs on 2017/5/16.
 * 18:23
 */
public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
        System.out.println("模拟删除Topic记录:" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeForum(int forumId) {
        System.out.println("模拟删除Forum记录:" +forumId);

        try {
            Thread.currentThread().sleep(40);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
