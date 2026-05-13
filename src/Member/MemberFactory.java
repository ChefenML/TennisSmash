package Member;
import java.util.ArrayList;
import java.util.List;
public class MemberFactory {
ArrayList<Member>Members;


    private List<Member> members;

    // Constructor
    public MemberFactory() {
        this.members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Member> getMembers() {
        return members;
    }
}
