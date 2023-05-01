package com.assignments.JoseAssignemnt14.repository;


import com.assignments.JoseAssignemnt14.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long> {


}
