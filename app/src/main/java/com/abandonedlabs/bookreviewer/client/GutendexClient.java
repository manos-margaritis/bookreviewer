package com.abandonedlabs.bookreviewer.client;

import com.abandonedlabs.bookreviewer.dto.BookDTO;
import com.abandonedlabs.bookreviewer.dto.GutendexResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.stream.Collectors;

/**
 * The type Gutendex client.
 */
@Component
public class GutendexClient {

    @Value("${gutendex.path}")
    private String gutendexPath;

    /**
     * Gets books by term.
     *
     * @param term the term
     * @param page the page
     * @return the books by term
     */
    @Cacheable("bookByTerm")
    public GutendexResponseDTO getBooksByTerm(String term, Long page) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(gutendexPath)
                .queryParam("search",term)
                .queryParam("page", page)
                .build();

        return restTemplate.getForObject(builder.toString(), GutendexResponseDTO.class);
    }

    /**
     * Gets book by id.
     *
     * @param bookId the book id
     * @return the book by id
     */
    @Cacheable("bookById")
    public BookDTO getBookById(Long bookId) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(gutendexPath + "/" + bookId, BookDTO.class);
    }

    /*
     * This method was merely created to demonstrate the identification of the difference between the requirements
     * (that states the search will work for book title) and the actual Gutendex API that also searches for actor names.
     */
    @Deprecated
    private GutendexResponseDTO filterOnlyTitles(GutendexResponseDTO gutendexResponseDTO, String term) {
        gutendexResponseDTO.setResults(gutendexResponseDTO.getResults().stream().filter(book -> book.getTitle().contains(term)).collect(Collectors.toList()));
        return gutendexResponseDTO;
    }

}
