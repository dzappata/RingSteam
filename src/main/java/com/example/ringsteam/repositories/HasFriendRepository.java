package com.example.ringsteam.repositories;

import com.example.ringsteam.models.HasFriend;
import com.example.ringsteam.models.HasFriendID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HasFriendRepository extends JpaRepository<HasFriend,HasFriendID> {

    List<HasFriend> findHasFriendByIduser(long idUser);

}
