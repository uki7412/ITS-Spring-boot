package com.example.ITS.domain.issue;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor//←lombokがコンストラクタを生成。⌘７で画面左下に出てくるストラクチャで確認できる
@Data //←ゲッターセッターtoStringもlombokが生成してくれる。
public class IssueEntity {
    private long id;
    private String summary;
    private String description;

}
