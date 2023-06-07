package com.flamexander.spring.ws.services;

import com.flamexander.spring.ws.repositories.GroupRepository;
import com.flamexander.spring.ws.entities.GroupEntity;
import com.flamexander.spring.ws.soap.groups.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public static final Function<GroupEntity, Group> functionEntityToSoap = ge -> {
        Group g = new Group();
        g.setTitle(g.getTitle());
        ge.getStudents().stream().map(StudentService.functionEntityToSoap).forEach(s -> g.getStudents().add(s));
        return g;
    };

    public Group getByTitle(String title) {
        return groupRepository.findByTitle(title).map(functionEntityToSoap).get();
    }
}
