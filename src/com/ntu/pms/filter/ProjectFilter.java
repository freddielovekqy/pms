package com.ntu.pms.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.model.ProjectUser;

public class ProjectFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.indexOf("/project") != -1) {
            HttpSession session = request.getSession();
            UserDTO userDTO = (UserDTO) session.getAttribute("currentUser");
            @SuppressWarnings("unchecked")
            Map<Integer, List<ProjectUser>> map = (Map<Integer, List<ProjectUser>>) session
                    .getAttribute("allProjectUsers");
            String projectId = request.getParameter("projectId");
            if (StringUtils.isNotEmpty(projectId)) {
                List<ProjectUser> projectUsers = map.get(Integer.parseInt(projectId));
                for (ProjectUser projectUser : projectUsers) {
                    if (projectUser.getUserId() == userDTO.getId()) {
                        chain.doFilter(request, response);
                        return;
                    }
                }
            }
        }
    }

}
