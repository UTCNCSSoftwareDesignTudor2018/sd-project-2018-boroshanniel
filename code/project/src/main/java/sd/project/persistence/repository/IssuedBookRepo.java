package sd.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sd.project.persistence.entity.Book;
import sd.project.persistence.entity.IssuedBook;
import sd.project.persistence.entity.Member;

import java.util.Date;
import java.util.List;

@Repository
public interface IssuedBookRepo extends JpaRepository<IssuedBook,Integer> {

    List<IssuedBook> findAllByMember(Member member);

    List<IssuedBook> findAllByBook(Book book);

    List<IssuedBook> findAllByDueDateIsLessThan(Date date);

    IssuedBook findByBookAndMember(Book book,Member member);

    List<IssuedBook> findAllByMemberAndCompleted(Member member,Integer completed);
}
