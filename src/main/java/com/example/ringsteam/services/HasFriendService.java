package com.example.ringsteam.services;
import com.example.ringsteam.exceptions.HasFriendNotFoundException;
import com.example.ringsteam.exceptions.UserNotFoundException;
import com.example.ringsteam.models.HasFriend;
import com.example.ringsteam.models.HasFriendID;
import com.example.ringsteam.repositories.HasFriendRepository;
import com.example.ringsteam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HasFriendService {

    private final HasFriendRepository hasFriendRepository;
    private final UserRepository userRepository;

    @Autowired
    public HasFriendService(HasFriendRepository hasFriendRepository, UserRepository userRepository) {
        this.hasFriendRepository = hasFriendRepository;
        this.userRepository = userRepository;
    }

    //Lista degli amici di un utente
    public List<HasFriend> getAllFriends(long idUser) {
        return hasFriendRepository.findHasFriendByIduser(idUser);
    }

    //Aggiungi un amico
    public void addFriend(long idUser, long idFriend) {
        userRepository.findById(idUser).orElseThrow(()-> new UserNotFoundException(idUser));
        userRepository.findById(idFriend).orElseThrow(()-> new UserNotFoundException(idFriend));


        HasFriendID idHasFriend = new HasFriendID(idUser,idFriend);

        if (!hasFriendRepository.existsById(idHasFriend)) {
            HasFriend addedFriend = new HasFriend(idUser, idFriend);
            hasFriendRepository.save(addedFriend);
        }
        else
        {
            throw new RuntimeException("Friend already exists");
        }
    }

    //Cancella un amico
    public void deleteFriend(long idUser, long idFriend) {
        HasFriendID idHasFriend = new HasFriendID(idUser,idFriend);
        hasFriendRepository.findById(idHasFriend).orElseThrow(()-> new HasFriendNotFoundException());

        hasFriendRepository.deleteById(idHasFriend);
    }
}
