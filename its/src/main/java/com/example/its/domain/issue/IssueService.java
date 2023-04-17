package com.example.its.domain.issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public List<IssueEntity> findAll() {
        return issueRepository.findAll();
    }
}
