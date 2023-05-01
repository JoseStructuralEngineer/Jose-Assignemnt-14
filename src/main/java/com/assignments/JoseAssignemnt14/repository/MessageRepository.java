package com.assignments.JoseAssignemnt14.repository;

import com.assignments.JoseAssignemnt14.domain.Channel;
import com.assignments.JoseAssignemnt14.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findByChannelId(Long channelId);

}
