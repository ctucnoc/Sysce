package com.sys.mype.sysce.pe.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sys.mype.sysce.pe.model.BHtmlTemplate;

@Repository
public interface HtmlTemplateRepository extends JpaRepository<BHtmlTemplate, Integer> {
	public Optional<BHtmlTemplate> findByHtmlTemplateCodeAndHtmlTemplateStatus(String code, String status);
}
