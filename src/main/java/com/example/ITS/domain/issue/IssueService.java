package com.example.ITS.domain.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //←ビジネスロジック層なので。これでbean登録完了。次にインジェクションの受け口である引数ありコンストラクタ用意。
@RequiredArgsConstructor//これでIssueRepositoryを初期化できる。このコンストラクタにインジェクションされてくる。
public class IssueService { //IssueRepositoryのインスタンスがインジェクションされてくる(↑の話)

    private final IssueRepository issueRepository;
    public List<IssueEntity> findAll() {
        return issueRepository.findAll();//これでDBからデータを呼び出してくることができる
    }
    @Transactional
    public void create(String summary, String description) {
        issueRepository.insert(summary, description);
    }

    public IssueEntity findById(long issueId) {
        return issueRepository.findById(issueId);
    }
}
