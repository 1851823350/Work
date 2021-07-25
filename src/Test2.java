class HeroNode{            //节点的属性
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;     //指向下一个节点
    public HeroNode pre;     //指向上一个节点

    public HeroNode(int no,String name,String nickname){
        this.name = name;
        this.no = no;
        this.nickname = nickname;
    }

    public String toString(){
        return "HeroNode [ no = " + no + "name = " + name + "nickname = " + nickname + "]";
    }
}
class DoubleLinkList {
    //初始化一个头节点,不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    //遍历节点
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    //增添节点
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改
    public void upDate(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.println("未找到相应的节点");
        }
    }

    //删除节点
    public void del(int no){
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            if(temp != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("未能找到相应删除的节点");
        }
    }

    //查找节点
    public void findIndex(int index){
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == index){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println(temp);
        }else {
            System.out.println("未能找到相应的节点");
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        //增添
        HeroNode hero1 = new HeroNode(2, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(1, "卢", "玉麒麟");

        DoubleLinkList doubleLinkList = new DoubleLinkList();
        doubleLinkList.add(hero1);
        doubleLinkList.add(hero2);
        doubleLinkList.list();

        System.out.println("------------");

        //删除
        doubleLinkList.del(2);
        doubleLinkList.list();

        System.out.println("-------------");

        //查找
        doubleLinkList.findIndex(4);

        System.out.println("--------------");

        //修改
        HeroNode hero3 = new HeroNode(1,"SJ","JSY");
        doubleLinkList.upDate(hero3);
        doubleLinkList.list();
    }
}
