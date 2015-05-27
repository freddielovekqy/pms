package com.ntu.pms.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.constant.PageNameConstant;
import com.ntu.pms.dto.AttachmentDTO;
import com.ntu.pms.dto.FolderDTO;
import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.dto.ProjectUserDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.service.AttachmentService;
import com.ntu.pms.service.FolderService;
import com.ntu.pms.service.ProjectService;
import com.ntu.pms.service.ProjectUserService;

@RestController
@RequestMapping("attachment")
public class AttchamentController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private FolderService folderService;
    @Autowired
    private ProjectUserService projectUserService;

    @RequestMapping(value = "findAttachmentDTOByFolder", method = RequestMethod.GET)
    public List<AttachmentDTO> findAttachmentDTOByFolder(@RequestParam("projectId") int projectId,
            @RequestParam("folderName") String folderName) {
        List<AttachmentDTO> attachmentDTOs = attachmentService.findAttachmentDTOByFolder(projectId, folderName);
        return attachmentDTOs;
    }

    @RequestMapping(value = "uploadAttachment", method = RequestMethod.POST)
    public AttachmentDTO uploadAttachment(@RequestParam("baseFolderName") String baseFolderName,
            @RequestParam("projectId") int projectId, MultipartHttpServletRequest multipartRequest) throws IOException {
        MultipartFile file = multipartRequest.getFile("file");
        AttachmentDTO attachmentDTO = attachmentService.uploadAttachment(projectId, baseFolderName, file,
                getCurrentLoginUser());
        return attachmentDTO;
    }

    @RequestMapping(value = "downloadAttachment", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadAttachment(@RequestParam("attachmentId") int attachmentId,
            @RequestParam("projectId") int projectId) throws IOException, BussinessException {
        File file = attachmentService.downloadAttachment(projectId, attachmentId);
        AttachmentDTO attachmentDTO = attachmentService.getDTOById(attachmentId);
        String fileName = new String(attachmentDTO.getName().getBytes("UTF-8"), "iso-8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "deleteAttachment", method = RequestMethod.POST)
    public AttachmentDTO deleteAttachment(@RequestParam("attachmentId") int attachmentId,
            @RequestParam("projectId") int projectId) {
        AttachmentDTO attachmentDTO = attachmentService.deleteAttachment(projectId, attachmentId);
        return attachmentDTO;
    }

    @RequestMapping(value = "showFolderList", method = RequestMethod.GET)
    public ModelAndView showFolderList(@RequestParam("projectId") int projectId) throws BussinessException {
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_FILE_MAIN_PAGE);
        List<FolderDTO> folderDTOs = folderService.getDTOsByProject(projectId);
        ProjectDTO projectDTO = projectService.getProjectDTOById(projectId);
        List<ProjectUserDTO> projectUserDTOs = projectUserService.getProjectUserDTOsByProjectId(projectId);
        List<ProjectDTO> projectDTOs = projectService.findProjectDTOsByUser(getCurrentLoginUser().getId(), projectId);
        mav.addObject(EntityConstants.FOLDER_DTOS, folderDTOs);
        mav.addObject(EntityConstants.PROJECT_USER_DTOS, projectUserDTOs);
        mav.addObject(EntityConstants.PROJECT_DTO, projectDTO);
        mav.addObject(EntityConstants.PROJECT_DTOS, projectDTOs);
        return mav;
    }

    @RequestMapping(value = "addFolder", method = RequestMethod.POST)
    public FolderDTO addFolder(@RequestParam("projectId") int projectId, @RequestParam("folderName") String folderName) {
        FolderDTO folderDTO = folderService.addFolder(projectId, folderName, getCurrentLoginUser());
        return folderDTO;
    }

    @RequestMapping(value = "removeFolder", method = RequestMethod.POST)
    public FolderDTO removeFolder(@RequestParam("folderId") int folderId) {
        FolderDTO folderDTO = folderService.removeFolder(folderId);
        return folderDTO;
    }

    @RequestMapping(value = "updateFolder", method = RequestMethod.POST)
    public FolderDTO updateFolder(@RequestParam("folderName") String folderName, @RequestParam("folderId") int folderId) {
        FolderDTO folderDTO = folderService.updateFolder(folderId, folderName);
        return folderDTO;
    }

}
