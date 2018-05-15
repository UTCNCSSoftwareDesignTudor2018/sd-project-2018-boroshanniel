package sd.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sd.project.persistence.entity.Member;
import sd.project.persistence.entity.User;
import sd.project.persistence.repository.MemberRepo;
import sd.project.persistence.repository.UserRepo;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {

    @Inject
    UserRepo userRepo;
    @Inject
    MemberRepo memberRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void persistenceTest(){
        //test admin


        User user = new User();
        user.setFlag(1);
        user.setCnp("1234567891111");
        user.setEmail("email");
        user.setUsername("paul");
        user.setPassword("123");
        user.setName("gordan paul");
        user.setPhoneNumber("1234567891111");

        Member member = new Member();
        member.setUser(user);

        user.setMember(member);

        userRepo.save(user);
        memberRepo.save(member);

	}
}

