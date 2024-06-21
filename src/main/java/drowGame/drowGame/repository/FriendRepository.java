package drowGame.drowGame.repository;

import drowGame.drowGame.entity.FriendEntity;
import drowGame.drowGame.entity.FriendId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FriendRepository {
    @PersistenceContext
    EntityManager em;

    public void addFriend(FriendEntity friendEntity, FriendEntity friendEntity1) {
        em.persist(friendEntity);
        em.persist(friendEntity1);
    }

    public List<FriendEntity> findFriendList(String myId) {
        return em.createQuery("select f from FriendEntity as f where f.id.member_id = :myId", FriendEntity.class)
                .setParameter("myId", myId)
                .getResultList();
    }
}
