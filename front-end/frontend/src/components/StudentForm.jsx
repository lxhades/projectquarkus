import React from 'react'

const StudentForm = ({ isEditing, formData, handleChange, handleSubmit, resetForm }) => {
    
  return (
    <div style={{ marginBottom: 20 }}>
        <h3>{isEditing ? "Edit Student" : "Add Student"}</h3>

        <input name="msv" value={formData.msv} onChange={handleChange} />
        <input name="name" value={formData.name} onChange={handleChange} />
        <input name="email" value={formData.email} onChange={handleChange} />
        <input name="className" value={formData.className} onChange={handleChange} />
        <input name="credit" value={formData.credit} onChange={handleChange} />
        <input type="date" name="birthDate" value={formData.birthDate} onChange={handleChange} />

        <select name="is_active" value={formData.is_active} onChange={handleChange}>
          <option value={true}>Active</option>
          <option value={false}>Inactive</option>
        </select>

        <br />

        <button onClick={handleSubmit}>
          {isEditing ? "Update" : "Add"}
        </button>

        <button onClick={resetForm}>Reset</button>
      </div>
  )
}

export default StudentForm