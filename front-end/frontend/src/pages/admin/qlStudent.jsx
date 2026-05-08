import React from "react";
import { useStudents } from "../../hooks/useStudents";
import StudentTable from "../../components/StudentTable";
import StudentForm from "../../components/StudentForm";
const QlStudent = () => {
  const {
    students,
    addStudent,
    editStudent,
    removeStudent
  } = useStudents();

  const [search, setSearch] = React.useState("");

  const [toast, setToast] = React.useState({
    show: false,
    message: "",
    type: "success"
  });

  const [formData, setFormData] = React.useState({
    msv: "",
    name: "",
    email: "",
    className: "",
    credit: "",
    is_active: true,
    birthDate: ""
  });

  const [isEditing, setIsEditing] = React.useState(false);

  // TOAST
  const showToast = (message, type = "success") => {
    setToast({ show: true, message, type });

    setTimeout(() => {
      setToast({ show: false, message: "", type: "success" });
    }, 2000);
  };

  // INPUT
  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData({
      ...formData,
      [name]: value
    });
  };

  // RESET
  const resetForm = () => {
    setFormData({
      msv: "",
      name: "",
      email: "",
      className: "",
      credit: "",
      is_active: true,
      birthDate: ""
    });
    setIsEditing(false);
  };

  // SUBMIT (CREATE / UPDATE)
  const handleSubmit = async () => {

    try {
      if (isEditing) {
        const ok = window.confirm("Bạn có chắc muốn update sinh viên này không?");

        if (!ok) return;
        await editStudent(formData.msv, formData);
        showToast("Cập nhật thành công 🎉");
      } else {
        const ok = window.confirm("Bạn có chắc muốn thêm sinh viên này không?");

        if (!ok) return;
        await addStudent(formData);
        showToast("Thêm sinh viên thành công 🎉");
      }

      resetForm();
    } catch (err) {
      showToast("Có lỗi xảy ra!", "error");
    }
  };

  // EDIT
  const handleEdit = (student) => {
    setFormData(student);
    setIsEditing(true);
  };

  // DELETE
  const handleDelete = async (msv) => {
    const ok = window.confirm("Bạn có chắc muốn xóa sinh viên này không?");

    if (!ok) return;
    try {
      await removeStudent(msv);
      showToast("Xóa thành công 🗑️");
    } catch (err) {
      showToast("Xóa thất bại!", "error");
    }
  };

  // SEARCH
  const filteredStudents = students.filter((s) =>
    `${s.msv} ${s.name} ${s.email}`
      .toLowerCase()
      .includes(search.toLowerCase())
  );

  return (
    <div style={{ padding: 20 }}>
      <h2>🎓 Quản lý sinh viên</h2>

      {/* TOAST */}
      {toast.show && (
        <div
          style={{
            padding: 10,
            background: toast.type === "success" ? "green" : "red",
            color: "white",
            marginBottom: 10
          }}
        >
          {toast.message}
        </div>
      )}

      {/* SEARCH */}
      <input
        placeholder="Tìm kiếm..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
        style={{ width: "100%", padding: 8, marginBottom: 10 }}
      />

      {/* FORM */}
      <StudentForm
        isEditing={isEditing}
        formData={formData}
        handleChange={handleChange}
        handleSubmit={handleSubmit}
        resetForm={resetForm}
      />

      <StudentTable
        students={filteredStudents}
        onEdit={handleEdit}
        onDelete={handleDelete}
      />
    </div>
  );
};

export default QlStudent;