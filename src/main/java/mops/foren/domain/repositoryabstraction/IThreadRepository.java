package mops.foren.domain.repositoryabstraction;

import mops.foren.domain.model.Post;
import mops.foren.domain.model.Thread;
import mops.foren.domain.model.ThreadId;
import mops.foren.domain.model.TopicId;
import mops.foren.domain.model.paging.ThreadPage;

import java.util.List;

public interface IThreadRepository {
    ThreadPage getThreadPageFromDB(TopicId topicId, Integer page);

    List<Thread> getThreadsFromDB(TopicId topicId);

    Thread getThreadById(ThreadId threadId);

    void addPostInThread(ThreadId threadId, Post post);
}
