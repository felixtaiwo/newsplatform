package newsplatform.Repository;


import newsplatform.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface NewsRepository extends PagingAndSortingRepository<News, Integer> {
    @Query(value = "SELECT newsId,newsTitle from News")
    public Page<News> findIt(Pageable pageable);

}



